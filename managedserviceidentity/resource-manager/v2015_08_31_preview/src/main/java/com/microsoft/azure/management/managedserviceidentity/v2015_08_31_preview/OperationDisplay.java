/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.managedserviceidentity.v2015_08_31_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Operation Display.
 * The object that describes the operation.
 */
public class OperationDisplay {
    /**
     * Resource Provider Name.
     * Friendly name of the resource provider.
     */
    @JsonProperty(value = "provider")
    private String provider;

    /**
     * Operation Type.
     * The type of operation. For example: read, write, delete.
     */
    @JsonProperty(value = "operation")
    private String operation;

    /**
     * Resource Type.
     * The resource type on which the operation is performed.
     */
    @JsonProperty(value = "resource")
    private String resource;

    /**
     * Operation description.
     * A description of the operation.
     */
    @JsonProperty(value = "description")
    private String description;

    /**
     * Get friendly name of the resource provider.
     *
     * @return the provider value
     */
    public String provider() {
        return this.provider;
    }

    /**
     * Set friendly name of the resource provider.
     *
     * @param provider the provider value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withProvider(String provider) {
        this.provider = provider;
        return this;
    }

    /**
     * Get the type of operation. For example: read, write, delete.
     *
     * @return the operation value
     */
    public String operation() {
        return this.operation;
    }

    /**
     * Set the type of operation. For example: read, write, delete.
     *
     * @param operation the operation value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withOperation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get the resource type on which the operation is performed.
     *
     * @return the resource value
     */
    public String resource() {
        return this.resource;
    }

    /**
     * Set the resource type on which the operation is performed.
     *
     * @param resource the resource value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withResource(String resource) {
        this.resource = resource;
        return this;
    }

    /**
     * Get a description of the operation.
     *
     * @return the description value
     */
    public String description() {
        return this.description;
    }

    /**
     * Set a description of the operation.
     *
     * @param description the description value to set
     * @return the OperationDisplay object itself.
     */
    public OperationDisplay withDescription(String description) {
        this.description = description;
        return this;
    }

}
