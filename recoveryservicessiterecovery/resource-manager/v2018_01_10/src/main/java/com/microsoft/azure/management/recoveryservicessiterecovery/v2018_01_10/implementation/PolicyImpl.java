/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.implementation;

import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.Policy;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.UpdatePolicyInputProperties;
import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.CreatePolicyInputProperties;
import com.microsoft.azure.management.recoveryservicessiterecovery.v2018_01_10.PolicyProperties;
import rx.functions.Func1;

class PolicyImpl extends CreatableUpdatableImpl<Policy, PolicyInner, PolicyImpl> implements Policy, Policy.Definition, Policy.Update {
    private final RecoveryServicesManager manager;
    private String policyName;
    private CreatePolicyInputProperties cproperties;
    private UpdatePolicyInputProperties uproperties;

    PolicyImpl(String name, RecoveryServicesManager manager) {
        super(name, new PolicyInner());
        this.manager = manager;
        // Set resource name
        this.policyName = name;
        //
        this.cproperties = new CreatePolicyInputProperties();
        this.uproperties = new UpdatePolicyInputProperties();
    }

    PolicyImpl(PolicyInner inner, RecoveryServicesManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.policyName = inner.name();
        // set resource ancestor and positional variables
        this.policyName = IdParsingUtils.getValueFromIdByName(inner.id(), "replicationPolicies");
        //
        this.cproperties = new CreatePolicyInputProperties();
        this.uproperties = new UpdatePolicyInputProperties();
    }

    @Override
    public RecoveryServicesManager manager() {
        return this.manager;
    }

    @Override
    public Observable<Policy> createResourceAsync() {
        ReplicationPoliciesInner client = this.manager().inner().replicationPolicies();
        return client.createAsync(this.policyName, this.cproperties)
            .map(new Func1<PolicyInner, PolicyInner>() {
               @Override
               public PolicyInner call(PolicyInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Policy> updateResourceAsync() {
        ReplicationPoliciesInner client = this.manager().inner().replicationPolicies();
        return client.updateAsync(this.policyName, this.uproperties)
            .map(new Func1<PolicyInner, PolicyInner>() {
               @Override
               public PolicyInner call(PolicyInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<PolicyInner> getInnerAsync() {
        ReplicationPoliciesInner client = this.manager().inner().replicationPolicies();
        return client.getAsync(this.policyName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.cproperties = new CreatePolicyInputProperties();
        this.uproperties = new UpdatePolicyInputProperties();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public PolicyProperties properties() {
        return this.inner().properties();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public PolicyImpl withExistingVault() {
        return this;
    }

    @Override
    public PolicyImpl withProperties(CreatePolicyInputProperties properties) {
        this.cproperties = properties;
        return this;
    }

    @Override
    public PolicyImpl withProperties(UpdatePolicyInputProperties properties) {
        this.uproperties = properties;
        return this;
    }

}
