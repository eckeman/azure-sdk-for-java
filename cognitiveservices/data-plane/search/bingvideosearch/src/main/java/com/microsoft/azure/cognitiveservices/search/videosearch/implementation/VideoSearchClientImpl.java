/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.search.videosearch.implementation;

import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.azure.cognitiveservices.search.videosearch.Videos;
import com.microsoft.azure.cognitiveservices.search.videosearch.VideoSearchClient;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.RestClient;

/**
 * Initializes a new instance of the VideoSearchClientImpl class.
 */
public class VideoSearchClientImpl extends AzureServiceClient implements VideoSearchClient {
    /** the {@link AzureClient} used for long running operations. */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /** Supported Cognitive Services endpoints (protocol and hostname, for example: "https://westus.api.cognitive.microsoft.com", "https://api.cognitive.microsoft.com"). */
    private String endpoint;

    /**
     * Gets Supported Cognitive Services endpoints (protocol and hostname, for example: "https://westus.api.cognitive.microsoft.com", "https://api.cognitive.microsoft.com").
     *
     * @return the endpoint value.
     */
    public String endpoint() {
        return this.endpoint;
    }

    /**
     * Sets Supported Cognitive Services endpoints (protocol and hostname, for example: "https://westus.api.cognitive.microsoft.com", "https://api.cognitive.microsoft.com").
     *
     * @param endpoint the endpoint value.
     * @return the service client itself
     */
    public VideoSearchClientImpl withEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    /** The preferred language for the response. */
    private String acceptLanguage;

    /**
     * Gets The preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets The preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public VideoSearchClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /** The retry timeout in seconds for Long Running Operations. Default value is 30. */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public VideoSearchClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /** Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true. */
    private boolean generateClientRequestId;

    /**
     * Gets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public VideoSearchClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * The Videos object to access its operations.
     */
    private Videos videos;

    /**
     * Gets the Videos object to access its operations.
     * @return the Videos object.
     */
    public Videos videos() {
        return this.videos;
    }

    /**
     * Initializes an instance of VideoSearchClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public VideoSearchClientImpl(ServiceClientCredentials credentials) {
        this("https://{Endpoint}/bing/v7.0", credentials);
    }

    /**
     * Initializes an instance of VideoSearchClient client.
     *
     * @param baseUrl the base URL of the host
     * @param credentials the management credentials for Azure
     */
    private VideoSearchClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of VideoSearchClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public VideoSearchClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.endpoint = "https://api.cognitive.microsoft.com";
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.videos = new VideosImpl(restClient().retrofit(), this);
        this.azureClient = new AzureClient(this);
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("%s (%s, %s)", super.userAgent(), "VideoSearchClient", "1.0");
    }
}
