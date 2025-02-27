// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob;

import com.azure.core.util.Context;
import com.azure.storage.blob.models.BlobContainerListDetails;
import com.azure.storage.blob.models.ListBlobContainersOptions;
import com.azure.storage.blob.models.Logging;
import com.azure.storage.blob.models.Metrics;
import com.azure.storage.blob.models.PublicAccessType;
import com.azure.storage.blob.models.RetentionPolicy;
import com.azure.storage.blob.models.StorageAccountInfo;
import com.azure.storage.blob.models.StorageServiceProperties;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

/**
 * Code snippets for {@link BlobServiceClient}
 */
@SuppressWarnings({"unused"})
public class BlobServiceClientJavaDocCodeSnippets {
    private final BlobServiceClient client = JavaDocCodeSnippetsHelpers.getBlobServiceClient();
    private final Duration timeout = Duration.ofSeconds(30);

    /**
     * Code snippet for {@link BlobServiceClient#getBlobContainerClient(String)}
     */
    public void getContainerClient() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getBlobContainerClient#String
        BlobContainerClient blobContainerClient = client.getBlobContainerClient("containerName");
        // END: com.azure.storage.blob.BlobServiceClient.getBlobContainerClient#String
    }

    /**
     * Code snippet for {@link BlobServiceClient#createBlobContainer(String)}
     */
    public void createContainer() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.createBlobContainer#String
        BlobContainerClient blobContainerClient = client.createBlobContainer("containerName");
        // END: com.azure.storage.blob.BlobServiceClient.createBlobContainer#String
    }

    /**
     * Code snippet for {@link BlobServiceClient#createBlobContainerWithResponse(String, Map, PublicAccessType, Context)}
     */
    public void createContainerWithResponse() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.createBlobContainerWithResponse#String-Map-PublicAccessType-Context
        Map<String, String> metadata = Collections.singletonMap("metadata", "value");
        Context context = new Context("Key", "Value");

        BlobContainerClient blobContainerClient = client.createBlobContainerWithResponse(
            "containerName",
            metadata,
            PublicAccessType.CONTAINER,
            context).getValue();
        // END: com.azure.storage.blob.BlobServiceClient.createBlobContainerWithResponse#String-Map-PublicAccessType-Context
    }

    /**
     * Code snippet for {@link BlobServiceClient#deleteBlobContainer(String)}
     */
    public void deleteContainer() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.deleteBlobContainer#String
        try {
            client.deleteBlobContainer("container Name");
            System.out.printf("Delete container completed with status %n");
        } catch (UnsupportedOperationException error) {
            System.out.printf("Delete container failed: %s%n", error);
        }
        // END: com.azure.storage.blob.BlobServiceClient.deleteBlobContainer#String
    }

    /**
     * Code snippet for {@link BlobServiceClient#deleteBlobContainerWithResponse(String, Context)}
     */
    public void deleteContainerWithResponse() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.deleteBlobContainerWithResponse#String-Context
        Context context = new Context("Key", "Value");
        System.out.printf("Delete container completed with status %d%n",
            client.deleteBlobContainerWithResponse("containerName", context).getStatusCode());
        // END: com.azure.storage.blob.BlobServiceClient.deleteBlobContainerWithResponse#String-Context
    }

    /**
     * Code snippets for {@link BlobServiceClient#listBlobContainers()} and
     * {@link BlobServiceClient#listBlobContainers(ListBlobContainersOptions, Duration)}
     */
    public void listContainers() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.listBlobContainers
        client.listBlobContainers().forEach(container -> System.out.printf("Name: %s%n", container.getName()));
        // END: com.azure.storage.blob.BlobServiceClient.listBlobContainers

        // BEGIN: com.azure.storage.blob.BlobServiceClient.listBlobContainers#ListBlobContainersOptions-Duration
        ListBlobContainersOptions options = new ListBlobContainersOptions()
            .setPrefix("containerNamePrefixToMatch")
            .setDetails(new BlobContainerListDetails().setRetrieveMetadata(true));

        client.listBlobContainers(options, timeout).forEach(container -> System.out.printf("Name: %s%n", container.getName()));
        // END: com.azure.storage.blob.BlobServiceClient.listBlobContainers#ListBlobContainersOptions-Duration
    }

    /**
     * Code snippet for {@link BlobServiceClient#getProperties()}
     */
    public void getProperties() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getProperties
        StorageServiceProperties properties = client.getProperties();

        System.out.printf("Hour metrics enabled: %b, Minute metrics enabled: %b%n",
            properties.getHourMetrics().isEnabled(),
            properties.getMinuteMetrics().isEnabled());
        // END: com.azure.storage.blob.BlobServiceClient.getProperties
    }

    /**
     * Code snippet for {@link BlobServiceClient#getPropertiesWithResponse(Duration, Context)}
     */
    public void getPropertiesWithResponse() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getPropertiesWithResponse#Duration-Context
        Context context = new Context("Key", "Value");
        StorageServiceProperties properties = client.getPropertiesWithResponse(timeout, context).getValue();

        System.out.printf("Hour metrics enabled: %b, Minute metrics enabled: %b%n",
            properties.getHourMetrics().isEnabled(),
            properties.getMinuteMetrics().isEnabled());
        // END: com.azure.storage.blob.BlobServiceClient.getPropertiesWithResponse#Duration-Context
    }

    /**
     * Code snippet for {@link BlobServiceClient#setProperties(StorageServiceProperties)}
     */
    public void setProperties() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.setProperties#StorageServiceProperties
        RetentionPolicy loggingRetentionPolicy = new RetentionPolicy().setEnabled(true).setDays(3);
        RetentionPolicy metricsRetentionPolicy = new RetentionPolicy().setEnabled(true).setDays(1);

        StorageServiceProperties properties = new StorageServiceProperties()
            .setLogging(new Logging()
                .setWrite(true)
                .setDelete(true)
                .setRetentionPolicy(loggingRetentionPolicy))
            .setHourMetrics(new Metrics()
                .setEnabled(true)
                .setRetentionPolicy(metricsRetentionPolicy))
            .setMinuteMetrics(new Metrics()
                .setEnabled(true)
                .setRetentionPolicy(metricsRetentionPolicy));

        try {
            client.setProperties(properties);
            System.out.printf("Setting properties completed%n");
        } catch (UnsupportedOperationException error) {
            System.out.printf("Setting properties failed: %s%n", error);
        }
        // END: com.azure.storage.blob.BlobServiceClient.setProperties#StorageServiceProperties
    }

    /**
     * Code snippet for {@link BlobServiceClient#setPropertiesWithResponse(StorageServiceProperties, Duration, Context)}
     */
    public void setPropertiesWithResponse() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.setPropertiesWithResponse#StorageServiceProperties-Duration-Context
        RetentionPolicy loggingRetentionPolicy = new RetentionPolicy().setEnabled(true).setDays(3);
        RetentionPolicy metricsRetentionPolicy = new RetentionPolicy().setEnabled(true).setDays(1);

        StorageServiceProperties properties = new StorageServiceProperties()
            .setLogging(new Logging()
                .setWrite(true)
                .setDelete(true)
                .setRetentionPolicy(loggingRetentionPolicy))
            .setHourMetrics(new Metrics()
                .setEnabled(true)
                .setRetentionPolicy(metricsRetentionPolicy))
            .setMinuteMetrics(new Metrics()
                .setEnabled(true)
                .setRetentionPolicy(metricsRetentionPolicy));

        Context context = new Context("Key", "Value");

        System.out.printf("Setting properties completed with status %d%n",
            client.setPropertiesWithResponse(properties, timeout, context).getStatusCode());
        // END: com.azure.storage.blob.BlobServiceClient.setPropertiesWithResponse#StorageServiceProperties-Duration-Context
    }

    /**
     * Code snippets for {@link BlobServiceClient#getUserDelegationKey(OffsetDateTime, OffsetDateTime)}
     * and {@link BlobServiceClient#getUserDelegationKeyWithResponse(OffsetDateTime, OffsetDateTime, Duration, Context)}
     */
    public void getUserDelegationKey() {
        OffsetDateTime delegationKeyStartTime = OffsetDateTime.now();
        OffsetDateTime delegationKeyExpiryTime = OffsetDateTime.now().plusDays(7);
        Context context = new Context("Key", "Value");
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getUserDelegationKey#OffsetDateTime-OffsetDateTime
        System.out.printf("User delegation key: %s%n",
            client.getUserDelegationKey(delegationKeyStartTime, delegationKeyExpiryTime));
        // END: com.azure.storage.blob.BlobServiceClient.getUserDelegationKey#OffsetDateTime-OffsetDateTime

        // BEGIN: com.azure.storage.blob.BlobServiceClient.getUserDelegationKeyWithResponse#OffsetDateTime-OffsetDateTime-Duration-Context
        System.out.printf("User delegation key: %s%n",
            client.getUserDelegationKeyWithResponse(delegationKeyStartTime, delegationKeyExpiryTime, timeout, context));
        // END: com.azure.storage.blob.BlobServiceClient.getUserDelegationKeyWithResponse#OffsetDateTime-OffsetDateTime-Duration-Context
    }

    /**
     * Code snippets for {@link BlobServiceClient#getStatistics()} and {@link BlobServiceClient#getStatisticsWithResponse(Duration, Context)}
     */
    public void getStatistics() {
        Context context = new Context("Key", "Value");
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getStatistics
        System.out.printf("Geo-replication status: %s%n",
            client.getStatistics().getGeoReplication().getStatus());
        // END: com.azure.storage.blob.BlobServiceClient.getStatistics

        // BEGIN: com.azure.storage.blob.BlobServiceClient.getStatisticsWithResponse#Duration-Context
        System.out.printf("Geo-replication status: %s%n",
            client.getStatisticsWithResponse(timeout, context).getValue().getGeoReplication().getStatus());
        // END: com.azure.storage.blob.BlobServiceClient.getStatisticsWithResponse#Duration-Context
    }

    /**
     * Code snippet for {@link BlobServiceClient#getAccountInfo}
     */
    public void getAccountInfo() {
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getAccountInfo
        StorageAccountInfo accountInfo = client.getAccountInfo();

        System.out.printf("Account kind: %s, SKU: %s%n", accountInfo.getAccountKind(), accountInfo.getSkuName());
        // END: com.azure.storage.blob.BlobServiceClient.getAccountInfo
    }

    /**
     * Code snippet for {@link BlobServiceClient#getAccountInfoWithResponse(Duration, Context)}
     */
    public void getAccountInfoWithResponse() {
        Context context = new Context("Key", "Value");
        // BEGIN: com.azure.storage.blob.BlobServiceClient.getAccountInfoWithResponse#Duration-Context
        StorageAccountInfo accountInfo = client.getAccountInfoWithResponse(timeout, context).getValue();
        // END: com.azure.storage.blob.BlobServiceClient.getAccountInfoWithResponse#Duration-Context
    }
}
