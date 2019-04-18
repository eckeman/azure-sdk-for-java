/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.kusto.v2019_01_21.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.microsoft.azure.ProxyResource;

/**
 * Class representing an data connection.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "kind")
@JsonTypeName("DataConnection")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "EventHub", value = EventHubDataConnection.class),
    @JsonSubTypes.Type(name = "EventGrid", value = EventGridDataConnection.class)
})
public class DataConnectionInner extends ProxyResource {
    /**
     * Resource location.
     */
    @JsonProperty(value = "location")
    private String location;

    /**
     * Get resource location.
     *
     * @return the location value
     */
    public String location() {
        return this.location;
    }

    /**
     * Set resource location.
     *
     * @param location the location value to set
     * @return the DataConnectionInner object itself.
     */
    public DataConnectionInner withLocation(String location) {
        this.location = location;
        return this;
    }

}
