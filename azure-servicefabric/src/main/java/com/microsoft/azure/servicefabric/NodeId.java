/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An internal ID used by Service Fabric to uniquely identify a node. Node Id
 * is deterministically generated from node name.
 */
public class NodeId {
    /**
     * Value of the node Id. This is a 128 bit integer.
     */
    @JsonProperty(value = "Id")
    private String id;

    /**
     * Get value of the node Id. This is a 128 bit integer.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Set value of the node Id. This is a 128 bit integer.
     *
     * @param id the id value to set
     * @return the NodeId object itself.
     */
    public NodeId withId(String id) {
        this.id = id;
        return this;
    }

}
