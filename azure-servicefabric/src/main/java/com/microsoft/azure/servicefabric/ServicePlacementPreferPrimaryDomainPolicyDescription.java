/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Describes the policy to be used for placement of a Service Fabric service
 * where the service's Primary replicas should optimally be placed in a
 * particular domain.
 *
 * This placement policy is usually used with fault domains in scenarios where
 * the Service Fabric cluster is geographically distributed in order to
 * indicate that a service's primary replica should be located in a particular
 * fault domain, which in geo-distributed scenarios usually aligns with
 * regional or datacenter boundaries. Note that since this is an optimization
 * it is possible that the Primary replica may not end up located in this
 * domain due to failures, capacity limits, or other constraints.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Type")
@JsonTypeName("PreferredPrimaryDomain")
public class ServicePlacementPreferPrimaryDomainPolicyDescription extends ServicePlacementPolicyDescription {
    /**
     * The name of the domain that should used for placement as per this
     * policy.
     */
    @JsonProperty(value = "DomainName")
    private String domainName;

    /**
     * Get the name of the domain that should used for placement as per this policy.
     *
     * @return the domainName value
     */
    public String domainName() {
        return this.domainName;
    }

    /**
     * Set the name of the domain that should used for placement as per this policy.
     *
     * @param domainName the domainName value to set
     * @return the ServicePlacementPreferPrimaryDomainPolicyDescription object itself.
     */
    public ServicePlacementPreferPrimaryDomainPolicyDescription withDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

}
