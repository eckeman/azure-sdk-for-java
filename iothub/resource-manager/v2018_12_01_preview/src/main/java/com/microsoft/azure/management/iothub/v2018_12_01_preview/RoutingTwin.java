/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.iothub.v2018_12_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Twin reference input parameter. This is an optional parameter.
 */
public class RoutingTwin {
    /**
     * Twin Tags.
     */
    @JsonProperty(value = "tags")
    private Object tags;

    /**
     * The properties property.
     */
    @JsonProperty(value = "properties")
    private RoutingTwinProperties properties;

    /**
     * Get twin Tags.
     *
     * @return the tags value
     */
    public Object tags() {
        return this.tags;
    }

    /**
     * Set twin Tags.
     *
     * @param tags the tags value to set
     * @return the RoutingTwin object itself.
     */
    public RoutingTwin withTags(Object tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the properties value.
     *
     * @return the properties value
     */
    public RoutingTwinProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties value.
     *
     * @param properties the properties value to set
     * @return the RoutingTwin object itself.
     */
    public RoutingTwin withProperties(RoutingTwinProperties properties) {
        this.properties = properties;
        return this;
    }

}
