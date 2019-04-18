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
 * The list of partition health state chunks that respect the input filters in
 * the chunk query description.
 * Returned by get cluster health state chunks query as part of the parent
 * application hierarchy.
 */
public class PartitionHealthStateChunkList {
    /**
     * The list of partition health state chunks that respect the input filters
     * in the chunk query.
     */
    @JsonProperty(value = "Items")
    private List<PartitionHealthStateChunk> items;

    /**
     * Get the list of partition health state chunks that respect the input filters in the chunk query.
     *
     * @return the items value
     */
    public List<PartitionHealthStateChunk> items() {
        return this.items;
    }

    /**
     * Set the list of partition health state chunks that respect the input filters in the chunk query.
     *
     * @param items the items value to set
     * @return the PartitionHealthStateChunkList object itself.
     */
    public PartitionHealthStateChunkList withItems(List<PartitionHealthStateChunk> items) {
        this.items = items;
        return this;
    }

}
