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
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonSubTypes;

/**
 * A ServiceUpdateDescription contains all of the information necessary to
 * update a service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "ServiceKind")
@JsonTypeName("ServiceUpdateDescription")
@JsonSubTypes({
    @JsonSubTypes.Type(name = "Stateful", value = StatefulServiceUpdateDescription.class),
    @JsonSubTypes.Type(name = "Stateless", value = StatelessServiceUpdateDescription.class)
})
public class ServiceUpdateDescription {
    /**
     * Flags indicating whether other properties are set. Each of the
     * associated properties corresponds to a flag, specified below, which, if
     * set, indicate that the property is specified.
     * This property can be a combination of those flags obtained using bitwise
     * 'OR' operator.
     * For example, if the provided value is 6 then the flags for
     * ReplicaRestartWaitDuration (2) and QuorumLossWaitDuration (4) are set.
     *
     * - None - Does not indicate any other properties are set. The value is
     * zero.
     * - TargetReplicaSetSize/InstanceCount - Indicates whether the
     * TargetReplicaSetSize property (for Stateful services) or the
     * InstanceCount property (for Stateless services) is set. The value is 1.
     * - ReplicaRestartWaitDuration - Indicates the ReplicaRestartWaitDuration
     * property is set. The value is  2.
     * - QuorumLossWaitDuration - Indicates the QuorumLossWaitDuration property
     * is set. The value is 4.
     * - StandByReplicaKeepDuration - Indicates the StandByReplicaKeepDuration
     * property is set. The value is 8.
     * - MinReplicaSetSize - Indicates the MinReplicaSetSize property is set.
     * The value is 16.
     * - PlacementConstraints - Indicates the PlacementConstraints property is
     * set. The value is 32.
     * - PlacementPolicyList - Indicates the ServicePlacementPolicies property
     * is set. The value is 64.
     * - Correlation - Indicates the CorrelationScheme property is set. The
     * value is 128.
     * - Metrics - Indicates the ServiceLoadMetrics property is set. The value
     * is 256.
     * - DefaultMoveCost - Indicates the DefaultMoveCost property is set. The
     * value is 512.
     * - ScalingPolicy - Indicates the ScalingPolicies property is set. The
     * value is 1024.
     */
    @JsonProperty(value = "Flags")
    private String flags;

    /**
     * The placement constraints as a string. Placement constraints are boolean
     * expressions on node properties and allow for restricting a service to
     * particular nodes based on the service requirements. For example, to
     * place a service on nodes where NodeType is blue specify the following:
     * "NodeColor == blue)".
     */
    @JsonProperty(value = "PlacementConstraints")
    private String placementConstraints;

    /**
     * The correlation scheme.
     */
    @JsonProperty(value = "CorrelationScheme")
    private List<ServiceCorrelationDescription> correlationScheme;

    /**
     * The service load metrics.
     */
    @JsonProperty(value = "LoadMetrics")
    private List<ServiceLoadMetricDescription> loadMetrics;

    /**
     * The service placement policies.
     */
    @JsonProperty(value = "ServicePlacementPolicies")
    private List<ServicePlacementPolicyDescription> servicePlacementPolicies;

    /**
     * The move cost for the service. Possible values include: 'Zero', 'Low',
     * 'Medium', 'High'.
     */
    @JsonProperty(value = "DefaultMoveCost")
    private MoveCost defaultMoveCost;

    /**
     * Scaling policies for this service.
     */
    @JsonProperty(value = "ScalingPolicies")
    private List<ScalingPolicyDescription> scalingPolicies;

    /**
     * Get flags indicating whether other properties are set. Each of the associated properties corresponds to a flag, specified below, which, if set, indicate that the property is specified.
     This property can be a combination of those flags obtained using bitwise 'OR' operator.
     For example, if the provided value is 6 then the flags for ReplicaRestartWaitDuration (2) and QuorumLossWaitDuration (4) are set.
     - None - Does not indicate any other properties are set. The value is zero.
     - TargetReplicaSetSize/InstanceCount - Indicates whether the TargetReplicaSetSize property (for Stateful services) or the InstanceCount property (for Stateless services) is set. The value is 1.
     - ReplicaRestartWaitDuration - Indicates the ReplicaRestartWaitDuration property is set. The value is  2.
     - QuorumLossWaitDuration - Indicates the QuorumLossWaitDuration property is set. The value is 4.
     - StandByReplicaKeepDuration - Indicates the StandByReplicaKeepDuration property is set. The value is 8.
     - MinReplicaSetSize - Indicates the MinReplicaSetSize property is set. The value is 16.
     - PlacementConstraints - Indicates the PlacementConstraints property is set. The value is 32.
     - PlacementPolicyList - Indicates the ServicePlacementPolicies property is set. The value is 64.
     - Correlation - Indicates the CorrelationScheme property is set. The value is 128.
     - Metrics - Indicates the ServiceLoadMetrics property is set. The value is 256.
     - DefaultMoveCost - Indicates the DefaultMoveCost property is set. The value is 512.
     - ScalingPolicy - Indicates the ScalingPolicies property is set. The value is 1024.
     *
     * @return the flags value
     */
    public String flags() {
        return this.flags;
    }

    /**
     * Set flags indicating whether other properties are set. Each of the associated properties corresponds to a flag, specified below, which, if set, indicate that the property is specified.
     This property can be a combination of those flags obtained using bitwise 'OR' operator.
     For example, if the provided value is 6 then the flags for ReplicaRestartWaitDuration (2) and QuorumLossWaitDuration (4) are set.
     - None - Does not indicate any other properties are set. The value is zero.
     - TargetReplicaSetSize/InstanceCount - Indicates whether the TargetReplicaSetSize property (for Stateful services) or the InstanceCount property (for Stateless services) is set. The value is 1.
     - ReplicaRestartWaitDuration - Indicates the ReplicaRestartWaitDuration property is set. The value is  2.
     - QuorumLossWaitDuration - Indicates the QuorumLossWaitDuration property is set. The value is 4.
     - StandByReplicaKeepDuration - Indicates the StandByReplicaKeepDuration property is set. The value is 8.
     - MinReplicaSetSize - Indicates the MinReplicaSetSize property is set. The value is 16.
     - PlacementConstraints - Indicates the PlacementConstraints property is set. The value is 32.
     - PlacementPolicyList - Indicates the ServicePlacementPolicies property is set. The value is 64.
     - Correlation - Indicates the CorrelationScheme property is set. The value is 128.
     - Metrics - Indicates the ServiceLoadMetrics property is set. The value is 256.
     - DefaultMoveCost - Indicates the DefaultMoveCost property is set. The value is 512.
     - ScalingPolicy - Indicates the ScalingPolicies property is set. The value is 1024.
     *
     * @param flags the flags value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withFlags(String flags) {
        this.flags = flags;
        return this;
    }

    /**
     * Get the placement constraints as a string. Placement constraints are boolean expressions on node properties and allow for restricting a service to particular nodes based on the service requirements. For example, to place a service on nodes where NodeType is blue specify the following: "NodeColor == blue)".
     *
     * @return the placementConstraints value
     */
    public String placementConstraints() {
        return this.placementConstraints;
    }

    /**
     * Set the placement constraints as a string. Placement constraints are boolean expressions on node properties and allow for restricting a service to particular nodes based on the service requirements. For example, to place a service on nodes where NodeType is blue specify the following: "NodeColor == blue)".
     *
     * @param placementConstraints the placementConstraints value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withPlacementConstraints(String placementConstraints) {
        this.placementConstraints = placementConstraints;
        return this;
    }

    /**
     * Get the correlation scheme.
     *
     * @return the correlationScheme value
     */
    public List<ServiceCorrelationDescription> correlationScheme() {
        return this.correlationScheme;
    }

    /**
     * Set the correlation scheme.
     *
     * @param correlationScheme the correlationScheme value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withCorrelationScheme(List<ServiceCorrelationDescription> correlationScheme) {
        this.correlationScheme = correlationScheme;
        return this;
    }

    /**
     * Get the service load metrics.
     *
     * @return the loadMetrics value
     */
    public List<ServiceLoadMetricDescription> loadMetrics() {
        return this.loadMetrics;
    }

    /**
     * Set the service load metrics.
     *
     * @param loadMetrics the loadMetrics value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withLoadMetrics(List<ServiceLoadMetricDescription> loadMetrics) {
        this.loadMetrics = loadMetrics;
        return this;
    }

    /**
     * Get the service placement policies.
     *
     * @return the servicePlacementPolicies value
     */
    public List<ServicePlacementPolicyDescription> servicePlacementPolicies() {
        return this.servicePlacementPolicies;
    }

    /**
     * Set the service placement policies.
     *
     * @param servicePlacementPolicies the servicePlacementPolicies value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withServicePlacementPolicies(List<ServicePlacementPolicyDescription> servicePlacementPolicies) {
        this.servicePlacementPolicies = servicePlacementPolicies;
        return this;
    }

    /**
     * Get the move cost for the service. Possible values include: 'Zero', 'Low', 'Medium', 'High'.
     *
     * @return the defaultMoveCost value
     */
    public MoveCost defaultMoveCost() {
        return this.defaultMoveCost;
    }

    /**
     * Set the move cost for the service. Possible values include: 'Zero', 'Low', 'Medium', 'High'.
     *
     * @param defaultMoveCost the defaultMoveCost value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withDefaultMoveCost(MoveCost defaultMoveCost) {
        this.defaultMoveCost = defaultMoveCost;
        return this;
    }

    /**
     * Get scaling policies for this service.
     *
     * @return the scalingPolicies value
     */
    public List<ScalingPolicyDescription> scalingPolicies() {
        return this.scalingPolicies;
    }

    /**
     * Set scaling policies for this service.
     *
     * @param scalingPolicies the scalingPolicies value to set
     * @return the ServiceUpdateDescription object itself.
     */
    public ServiceUpdateDescription withScalingPolicies(List<ScalingPolicyDescription> scalingPolicies) {
        this.scalingPolicies = scalingPolicies;
        return this;
    }

}
