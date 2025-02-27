// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.core.implementation;

import com.azure.core.MockServer;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineBuilder;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.AddDatePolicy;
import com.azure.core.http.policy.AddHeadersPolicy;
import com.azure.core.http.policy.HostPolicy;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLoggingPolicy;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.StreamResponse;
import com.azure.core.annotation.BodyParam;
import com.azure.core.annotation.Delete;
import com.azure.core.annotation.ExpectedResponses;
import com.azure.core.annotation.Get;
import com.azure.core.annotation.HeaderParam;
import com.azure.core.annotation.Host;
import com.azure.core.annotation.PathParam;
import com.azure.core.annotation.Put;
import com.azure.core.implementation.http.ContentType;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import reactor.core.Disposable;
import reactor.core.Exceptions;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.nio.ByteBuffer;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class RestProxyStressTests {
    private static IOService service;
    private static Process testServer;
    // By default will spawn a test server running on the default port.
    // If JAVA_SDK_TEST_PORT is specified in the environment, we assume
    // the server is already running on that port.
    private static int port = 8080;

    @BeforeClass
    public static void beforeClass() throws IOException {
        Assume.assumeTrue(
                "Set the environment variable JAVA_SDK_STRESS_TESTS to \"true\" to run stress tests",
                Boolean.parseBoolean(System.getenv("JAVA_SDK_STRESS_TESTS")));

        String tempFolderPath = System.getenv("JAVA_STRESS_TEST_TEMP_PATH");
        if (tempFolderPath == null || tempFolderPath.isEmpty()) {
            tempFolderPath = "temp";
        }

        HttpHeaders headers = new HttpHeaders().put("x-ms-version", "2017-04-17");
        // Order in which policies applied will be the order in which they added to builder
        List<HttpPipelinePolicy> polices = new ArrayList<HttpPipelinePolicy>();
        polices.add(new AddDatePolicy());
        polices.add(new AddHeadersPolicy(headers));
        polices.add(new ThrottlingRetryPolicy());
        //
        String liveStressTests = System.getenv("JAVA_SDK_TEST_SAS");
        if (liveStressTests == null || liveStressTests.isEmpty()) {
            launchTestServer();
            polices.add(new HostPolicy("http://localhost:" + port));
        }
        //
        polices.add(new HttpLoggingPolicy(HttpLogDetailLevel.BASIC, false));
        //
        service = RestProxy.create(IOService.class,
            new HttpPipelineBuilder()
                .policies(polices.toArray(new HttpPipelinePolicy[0]))
                .build());

        RestProxyStressTests.tempFolderPath = Paths.get(tempFolderPath);
        create100MFiles(false);
    }

    private static void launchTestServer() throws IOException {
        String portString = System.getenv("JAVA_SDK_TEST_PORT");
        // TODO: figure out why test server hangs only when spawned as a subprocess
        Assume.assumeTrue("JAVA_SDK_TEST_PORT must specify the port of a running local server", portString != null);
        if (portString != null) {
            port = Integer.parseInt(portString, 10);
            LoggerFactory.getLogger(RestProxyStressTests.class).warn("Attempting to connect to already-running test server on port {}", port);
        } else {
            String javaHome = System.getProperty("java.home");
            String javaExecutable = javaHome + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");
            String className = MockServer.class.getCanonicalName();

            ProcessBuilder builder = new ProcessBuilder(
                    javaExecutable, "-cp", classpath, className).redirectErrorStream(true).redirectOutput(Redirect.INHERIT);
            testServer = builder.start();
        }
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (testServer != null) {
            testServer.destroy();
        }
    }

    private static final class ThrottlingRetryPolicy implements HttpPipelinePolicy {
        @Override
        public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
            return process(1 + ThreadLocalRandom.current().nextInt(5), context, next);
        }

        Mono<HttpResponse> process(final int waitTimeSeconds, final HttpPipelineCallContext context, final HttpPipelineNextPolicy nextPolicy) {
            return nextPolicy.clone().process().flatMap(httpResponse -> {
                if (httpResponse.getStatusCode() != 503 && httpResponse.getStatusCode() != 500) {
                    return Mono.just(httpResponse);
                } else {
                    LoggerFactory.getLogger(getClass()).warn("Received " + httpResponse.getStatusCode() + " for request. Waiting " + waitTimeSeconds + " seconds before retry.");
                    final int nextWaitTime = 5 + ThreadLocalRandom.current().nextInt(10);
                    httpResponse.getBody().subscribe().dispose(); // TODO: Anu re-evaluate this
                    return Mono.delay(Duration.of(waitTimeSeconds, ChronoUnit.SECONDS))
                            .then(process(nextWaitTime, context, nextPolicy));
                }
            }).onErrorResume(throwable -> {
                if (throwable instanceof IOException) {
                    LoggerFactory.getLogger(getClass()).warn("I/O exception occurred: " + throwable.getMessage());
                    return process(context, nextPolicy).delaySubscription(Duration.of(waitTimeSeconds, ChronoUnit.SECONDS));
                }
                LoggerFactory.getLogger(getClass()).warn("Unrecoverable exception occurred: " + throwable.getMessage());
                return Mono.error(throwable);
            });
        }
    }

    @Host("https://javasdktest.blob.core.windows.net")
    interface IOService {
        @ExpectedResponses({201})
        @Put("/javasdktest/upload/100m-{id}.dat?{sas}")
        Mono<Response<Void>> upload100MB(@PathParam("id") String id, @PathParam(value = "sas", encoded = true) String sas, @HeaderParam("x-ms-blob-type") String blobType, @BodyParam(ContentType.APPLICATION_OCTET_STREAM) Flux<ByteBuffer> stream, @HeaderParam("content-length") long contentLength);

        @Get("/javasdktest/upload/100m-{id}.dat?{sas}")
        Mono<StreamResponse> download100M(@PathParam("id") String id, @PathParam(value = "sas", encoded = true) String sas);

        @ExpectedResponses({201})
        @Put("/testcontainer{id}?restype=container&{sas}")
        Mono<Response<Void>> createContainer(@PathParam("id") String id, @PathParam(value = "sas", encoded = true) String sas);

        @ExpectedResponses({202})
        @Delete("/testcontainer{id}?restype=container&{sas}")
        Mono<Response<Void>> deleteContainer(@PathParam("id") String id, @PathParam(value = "sas", encoded = true) String sas);
    }

    private static Path tempFolderPath;
    private static final int NUM_FILES = 100;
    private static final int FILE_SIZE = 1024 * 1024 * 100;
    private static final int CHUNK_SIZE = 8192;
    private static final int CHUNKS_PER_FILE = FILE_SIZE / CHUNK_SIZE;

    private static void deleteRecursive(Path tempFolderPath) throws IOException {
        try {
            Files.walkFileTree(tempFolderPath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc != null) {
                        throw exc;
                    }

                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (NoSuchFileException ignored) {
        }
    }

    private static void create100MFiles(boolean recreate) throws IOException {
//        final Flux<ByteBuffer> contentGenerator = Flux.generate(Random::new, (random, emitter) -> {
//            byte[] ba = new byte[CHUNK_SIZE];
//            random.nextBytes(ba);
//            emitter.next(ByteBuffer.wrap(ba));
//            return random;
//        });
//
//        if (recreate) {
//            deleteRecursive(tempFolderPath);
//        }
//
//        if (Files.exists(tempFolderPath)) {
//            LoggerFactory.getLogger(RestProxyStressTests.class).info("Temp files directory already exists: " + tempFolderPath.toAbsolutePath());
//        } else {
//            LoggerFactory.getLogger(RestProxyStressTests.class).info("Generating temp files in directory: " + tempFolderPath.toAbsolutePath());
//            Files.createDirectory(tempFolderPath);
//            Flux.range(0, NUM_FILES).flatMap(integer -> {
//                try {
//                    final int i = integer;
//                    final Path filePath = tempFolderPath.resolve("100m-" + i + ".dat");
//
//                    Files.deleteIfExists(filePath);
//                    Files.createFile(filePath);
//                    final AsynchronousFileChannel file = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ, StandardOpenOption.WRITE);
//                    final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//
//                    Flux<ByteBuffer> fileContent = contentGenerator
//                        .take(CHUNKS_PER_FILE)
//                        .doOnNext(buf -> messageDigest.update(buf.array()));
//
//                    return FluxUtil.bytebufStreamToFile(fileContent, file).then(Mono.fromRunnable(() -> {
//                        try {
//                            file.close();
//                            Files.write(tempFolderPath.resolve("100m-" + i + "-md5.dat"), messageDigest.digest());
//                            LoggerFactory.getLogger(RestProxyStressTests.class).info("Finished writing file " + i);
//                        } catch (Exception e) {
//                            throw Exceptions.propagate(e);
//                        }
//                    }));
//                } catch (Exception e) {
//                    return Flux.error(e);
//                }
//            }).blockLast();
//        }

        // TODO
        fail("This method is not yet re-implemented");
    }

    @Test
    @Ignore("Should only be run manually")
    public void prepare100MFiles() throws Exception {
        create100MFiles(true);
    }

    @Test
    public void upload100MParallelTest() {
//        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");
//
//        Flux<byte[]> md5s = Flux.range(0, NUM_FILES)
//            .map(integer -> {
//                final Path filePath = tempFolderPath.resolve("100m-" + integer + "-md5.dat");
//                try {
//                    return Files.readAllBytes(filePath);
//                } catch (IOException ioe) {
//                    throw Exceptions.propagate(ioe);
//                }
//            });
//        //
//        Instant uploadStart = Instant.now();
//        //
//        Flux.range(0, NUM_FILES)
//                .zipWith(md5s, (id, md5) -> {
//                    AsynchronousFileChannel fileStream = null;
//                    try {
//                        fileStream = AsynchronousFileChannel.open(tempFolderPath.resolve("100m-" + id + ".dat"));
//                    } catch (IOException ioe) {
//                        Exceptions.propagate(ioe);
//                    }
//                    return service.upload100MB(String.valueOf(id), sas, "BlockBlob", FluxUtil.byteBufStreamFromFile(fileStream), FILE_SIZE).map(response -> {
//                        String base64MD5 = response.headers().value("Content-MD5");
//                        byte[] receivedMD5 = Base64.getDecoder().decode(base64MD5);
//                        Assert.assertArrayEquals(md5, receivedMD5);
//                        return response;
//                    });
//                })
//                .flatMapDelayError(m -> m, 15, 1)
//                .blockLast();
//        //
//        long durationMilliseconds = Duration.between(uploadStart, Instant.now()).toMillis();
//        LoggerFactory.getLogger(getClass()).info("Upload took " + durationMilliseconds + " milliseconds.");
        Assert.fail("Need to implement this test again");
    }

    @Test
    public void uploadMemoryMappedTest() {
//        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");
//
//        Flux<byte[]> md5s = Flux.range(0, NUM_FILES)
//                .map(integer -> {
//                    final Path filePath = tempFolderPath.resolve("100m-" + integer + "-md5.dat");
//                    try {
//                        return Files.readAllBytes(filePath);
//                    } catch (IOException ioe) {
//                        throw Exceptions.propagate(ioe);
//                    }
//                });
//
//        Instant uploadStart = Instant.now();
//        //
//        Flux.range(0, NUM_FILES)
//                .zipWith(md5s, (id, md5) -> {
//                    FileChannel fileStream = null;
//                    try {
//                        fileStream = FileChannel.open(tempFolderPath.resolve("100m-" + id + ".dat"), StandardOpenOption.READ);
//                    } catch (IOException ioe) {
//                        Exceptions.propagate(ioe);
//                    }
//                    //
//                    ByteBuffer mappedByteBufFile = null;
//                    Flux<ByteBuffer> stream = null;
//                    try {
//                        MappedByteBuffer mappedByteBufferFile = fileStream.map(FileChannel.MapMode.READ_ONLY, 0, fileStream.size());
//                        mappedByteBufFile = Unpooled.wrappedBuffer(mappedByteBufferFile);
//                        stream = FluxUtil.split(mappedByteBufFile, CHUNK_SIZE);
//                    } catch (IOException ioe) {
//                        mappedByteBufFile.release();
//                        Exceptions.propagate(ioe);
//                    }
//                    //
//                    return service.upload100MB(String.valueOf(id), sas, "BlockBlob", stream, FILE_SIZE).map(response -> {
//                        String base64MD5 = response.headers().value("Content-MD5");
//                        byte[] receivedMD5 = Base64.getDecoder().decode(base64MD5);
//                        Assert.assertArrayEquals(md5, receivedMD5);
//                        return response;
//                    });
//                })
//                .flatMapDelayError(m -> m, 15, 1)
//                .blockLast();
//        //
//        long durationMilliseconds = Duration.between(uploadStart, Instant.now()).toMillis();
//        LoggerFactory.getLogger(getClass()).info("Upload took " + durationMilliseconds + " milliseconds.");
        Assert.fail("Need to implement this test again");
    }


    /**
     * Run after running one of the corresponding upload tests.
     */
    @Test
    public void download100MParallelTest() {
        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");

        Flux<byte[]> md5s = Flux.range(0, NUM_FILES)
                .map(integer -> {
                    final Path filePath = tempFolderPath.resolve("100m-" + integer + "-md5.dat");
                    try {
                        return Files.readAllBytes(filePath);
                    } catch (IOException ioe) {
                        throw Exceptions.propagate(ioe);
                    }
                });
        //
        Instant downloadStart = Instant.now();
        //
        Flux.range(0, NUM_FILES)
                .zipWith(md5s, (id, md5) -> {
                    return service.download100M(String.valueOf(id), sas).flatMap(response -> {
                        Flux<ByteBuffer> content;
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            content = response.getValue()
                                    .doOnNext(buf -> messageDigest.update(buf.slice()));

                            return content.last().doOnSuccess(b -> {
                                assertArrayEquals(md5, messageDigest.digest());
                                LoggerFactory.getLogger(getClass()).info("Finished downloading and MD5 validated for " + id);

                            });

                        } catch (NoSuchAlgorithmException nsae) {
                            throw Exceptions.propagate(nsae);
                        }
                    });
                })
                .flatMapDelayError(m -> m, 15, 1)
                .blockLast();
        //
        long durationMilliseconds = Duration.between(downloadStart, Instant.now()).toMillis();
        LoggerFactory.getLogger(getClass()).info("Download took " + durationMilliseconds + " milliseconds.");
    }

    @Test
    public void downloadUploadStreamingTest() {
        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");

        Flux<byte[]> md5s = Flux.range(0, NUM_FILES)
                .map(integer -> {
                    final Path filePath = tempFolderPath.resolve("100m-" + integer + "-md5.dat");
                    try {
                        return Files.readAllBytes(filePath);
                    } catch (IOException ioe) {
                        throw Exceptions.propagate(ioe);
                    }
                });
        //
        Instant downloadStart = Instant.now();
        //
        Flux.range(0, NUM_FILES)
                .zipWith(md5s, (integer, md5) -> {
                    final int id = integer;
                    Flux<ByteBuffer> downloadContent = service.download100M(String.valueOf(id), sas)
                            // Ideally we would intercept this content to load an MD5 to check consistency between download and upload directly,
                            // but it's sufficient to demonstrate that no corruption occurred between preparation->upload->download->upload.
                            .flatMapMany(StreamResponse::getValue)
                            .map(reactorNettybb -> {
                                //
                                // This test 'downloadUploadStreamingTest' exercises piping scenario.
                                //
                                //   A. Receive ByteBufFlux from reactor-netty from NettyInbound.receive() [via service.download100M].
                                //   B. Directly pass this ByteBufFlux to Outbound.send() [via service.upload100MB]
                                //
                                //   NettyOutbound.send(NettyInbound.receive())
                                //
                                // A property of ByteBufFlux publisher is - The chunks in the stream gets released automatically once 'onNext' returns.
                                //
                                // The Outbound.send method subscribe to ByteBufFlux
                                //     1. on each onNext call, the received ByteBuf chunk gets 'scheduled' to write through Netty.write()
                                //     2. onNext returns.
                                //     3. repeat 1 & 2 until stream completes or errored.
                                //
                                // The scheduling & immediate return from onNext [1 & 2] can result in the a chunk of ByteBufFlux to be released
                                // before the scheduled Netty.write() completes.
                                //
                                // This can cause following issues:
                                //   a. Write of content of released chunks, which is bad.
                                //   b. Netty.write() calls release on the ByteBuf after write is done. We have double release problem here.
                                //
                                // Solution is to aware of ByteBufFlux auto-release property and retain each chunk before passing to Netty.write().
                                //
//                                return reactorNettybb.retain();
                                // TODO
                                throw new IllegalStateException("This method is not yet re-implemented");
                            });
                    //
                    return service.upload100MB("copy-" + integer, sas, "BlockBlob", downloadContent, FILE_SIZE)
                            .flatMap(uploadResponse -> {
                                String base64MD5 = uploadResponse.getHeaders().getValue("Content-MD5");
                                byte[] uploadMD5 = Base64.getDecoder().decode(base64MD5);
                                assertArrayEquals(md5, uploadMD5);
                                LoggerFactory.getLogger(getClass()).info("Finished upload and validation for id " + id);
                                return Mono.just(uploadResponse);
                            });
                })
                .flatMapDelayError(m -> m, 30, 1)
                .blockLast();
        //
        long durationMilliseconds = Duration.between(downloadStart, Instant.now()).toMillis();
        LoggerFactory.getLogger(getClass()).info("Download/Upload took " + durationMilliseconds + " milliseconds.");
    }

    @Test
    public void cancellationTest() throws Exception {
        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");
        final Disposable d = Flux.range(0, NUM_FILES)
                .flatMap(integer ->
                        service.download100M(String.valueOf(integer), sas)
                                .flatMapMany(StreamResponse::getValue))
                .subscribe();

        Mono.delay(Duration.ofSeconds(10)).then(Mono.defer(() -> {
            d.dispose();
            return Mono.empty();
        })).block();
        // Wait to see if any leak reports come up
        Thread.sleep(10000);
    }

    @Test
    public void testHighParallelism() {
        final String sas = System.getenv("JAVA_SDK_TEST_SAS") == null ? "" : System.getenv("JAVA_SDK_TEST_SAS");

        HttpHeaders headers = new HttpHeaders().put("x-ms-version", "2017-04-17");
        // Order in which policies applied will be the order in which they added to builder
        //
        List<HttpPipelinePolicy> policies = new ArrayList<>();
        policies.add(new AddDatePolicy());
        policies.add(new AddHeadersPolicy(headers));
        policies.add(new ThrottlingRetryPolicy());

        if (sas == null || sas.isEmpty()) {
            policies.add(new HostPolicy("http://localhost:" + port));
        }

        final IOService innerService = RestProxy.create(IOService.class,
            new HttpPipelineBuilder()
                .policies(policies.toArray(new HttpPipelinePolicy[0]))
                .build());

        // When running with MockServer, connections sometimes get dropped,
        // but this doesn't seem to result in any bad behavior as long as we retry.

        Flux.range(0, 10000)
                .flatMap(integer ->
                        innerService.createContainer(integer.toString(), sas)
                                .onErrorResume(throwable -> {
                                    if (throwable instanceof HttpResponseException) {
                                        HttpResponseException restException = (HttpResponseException) throwable;
                                        if ((restException.getResponse().getStatusCode() == 409 || restException.getResponse().getStatusCode() == 404)) {
                                            return Mono.empty();
                                        }
                                    }
                                    return Mono.error(throwable);
                                })
                                .then(innerService.deleteContainer(integer.toString(), sas)))
                                .blockLast();
    }
}
