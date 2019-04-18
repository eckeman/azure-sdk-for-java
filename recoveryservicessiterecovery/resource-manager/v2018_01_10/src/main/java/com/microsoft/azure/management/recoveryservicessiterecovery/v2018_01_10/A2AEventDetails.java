/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Model class for event details of a A2A event.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "instanceType")
@JsonTypeName("A2A")
public class A2AEventDetails extends EventProviderSpecificDetails {
    /**
     * The protected item arm name.
     */
    @JsonProperty(value = "protectedItemName")
    private String protectedItemName;

    /**
     * The azure vm arm id.
     */
    @JsonProperty(value = "fabricObjectId")
    private String fabricObjectId;

    /**
     * Fabric arm name.
     */
    @JsonProperty(value = "fabricName")
    private String fabricName;

    /**
     * The fabric location.
     */
    @JsonProperty(value = "fabricLocation")
    private String fabricLocation;

    /**
     * Remote fabric arm name.
     */
    @JsonProperty(value = "remoteFabricName")
    private String remoteFabricName;

    /**
     * Remote fabric location.
     */
    @JsonProperty(value = "remoteFabricLocation")
    private String remoteFabricLocation;

    /**
     * Get the protected item arm name.
     *
     * @return the protectedItemName value
     */
    public String protectedItemName() {
        return this.protectedItemName;
    }

    /**
     * Set the protected item arm name.
     *
     * @param protectedItemName the protectedItemName value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withProtectedItemName(String protectedItemName) {
        this.protectedItemName = protectedItemName;
        return this;
    }

    /**
     * Get the azure vm arm id.
     *
     * @return the fabricObjectId value
     */
    public String fabricObjectId() {
        return this.fabricObjectId;
    }

    /**
     * Set the azure vm arm id.
     *
     * @param fabricObjectId the fabricObjectId value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withFabricObjectId(String fabricObjectId) {
        this.fabricObjectId = fabricObjectId;
        return this;
    }

    /**
     * Get fabric arm name.
     *
     * @return the fabricName value
     */
    public String fabricName() {
        return this.fabricName;
    }

    /**
     * Set fabric arm name.
     *
     * @param fabricName the fabricName value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withFabricName(String fabricName) {
        this.fabricName = fabricName;
        return this;
    }

    /**
     * Get the fabric location.
     *
     * @return the fabricLocation value
     */
    public String fabricLocation() {
        return this.fabricLocation;
    }

    /**
     * Set the fabric location.
     *
     * @param fabricLocation the fabricLocation value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withFabricLocation(String fabricLocation) {
        this.fabricLocation = fabricLocation;
        return this;
    }

    /**
     * Get remote fabric arm name.
     *
     * @return the remoteFabricName value
     */
    public String remoteFabricName() {
        return this.remoteFabricName;
    }

    /**
     * Set remote fabric arm name.
     *
     * @param remoteFabricName the remoteFabricName value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withRemoteFabricName(String remoteFabricName) {
        this.remoteFabricName = remoteFabricName;
        return this;
    }

    /**
     * Get remote fabric location.
     *
     * @return the remoteFabricLocation value
     */
    public String remoteFabricLocation() {
        return this.remoteFabricLocation;
    }

    /**
     * Set remote fabric location.
     *
     * @param remoteFabricLocation the remoteFabricLocation value to set
     * @return the A2AEventDetails object itself.
     */
    public A2AEventDetails withRemoteFabricLocation(String remoteFabricLocation) {
        this.remoteFabricLocation = remoteFabricLocation;
        return this;
    }

}
