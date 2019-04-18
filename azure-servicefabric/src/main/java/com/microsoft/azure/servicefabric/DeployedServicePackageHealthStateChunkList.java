/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The list of deployed service package health state chunks that respect the
 * input filters in the chunk query. Returned by get cluster health state
 * chunks query.
 */
public class DeployedServicePackageHealthStateChunkList {
    /**
     * The list of deployed service package health state chunks that respect
     * the input filters in the chunk query.
     */
    @JsonProperty(value = "Items")
    private List<DeployedServicePackageHealthStateChunk> items;

    /**
     * Get the list of deployed service package health state chunks that respect the input filters in the chunk query.
     *
     * @return the items value
     */
    public List<DeployedServicePackageHealthStateChunk> items() {
        return this.items;
    }

    /**
     * Set the list of deployed service package health state chunks that respect the input filters in the chunk query.
     *
     * @param items the items value to set
     * @return the DeployedServicePackageHealthStateChunkList object itself.
     */
    public DeployedServicePackageHealthStateChunkList withItems(List<DeployedServicePackageHealthStateChunk> items) {
        this.items = items;
        return this;
    }

}
