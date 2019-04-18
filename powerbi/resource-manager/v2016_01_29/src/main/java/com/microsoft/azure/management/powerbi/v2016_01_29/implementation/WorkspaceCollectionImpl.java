/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.powerbi.v2016_01_29.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.powerbi.v2016_01_29.WorkspaceCollection;
import rx.Observable;
import java.util.Map;
import com.microsoft.azure.management.powerbi.v2016_01_29.CreateWorkspaceCollectionRequest;
import com.microsoft.azure.management.powerbi.v2016_01_29.AzureSku;
import rx.functions.Func1;

class WorkspaceCollectionImpl extends GroupableResourceCoreImpl<WorkspaceCollection, WorkspaceCollectionInner, WorkspaceCollectionImpl, PowerBIManager> implements WorkspaceCollection, WorkspaceCollection.Definition, WorkspaceCollection.Update {
    private Map<String, String> utags;
    private CreateWorkspaceCollectionRequest createParameter;
    WorkspaceCollectionImpl(String name, WorkspaceCollectionInner inner, PowerBIManager manager) {
        super(name, inner, manager);
        this.createParameter = new CreateWorkspaceCollectionRequest();
    }

    @Override
    public Observable<WorkspaceCollection> createResourceAsync() {
        WorkspaceCollectionsInner client = this.manager().inner().workspaceCollections();
        this.createParameter.withLocation(inner().location());
        this.createParameter.withTags(inner().getTags());
        return client.createAsync(this.resourceGroupName(), this.name(), this.createParameter)
            .map(new Func1<WorkspaceCollectionInner, WorkspaceCollectionInner>() {
               @Override
               public WorkspaceCollectionInner call(WorkspaceCollectionInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<WorkspaceCollection> updateResourceAsync() {
        WorkspaceCollectionsInner client = this.manager().inner().workspaceCollections();
        return client.updateAsync(this.resourceGroupName(), this.name(), this.utags)
            .map(new Func1<WorkspaceCollectionInner, WorkspaceCollectionInner>() {
               @Override
               public WorkspaceCollectionInner call(WorkspaceCollectionInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<WorkspaceCollectionInner> getInnerAsync() {
        WorkspaceCollectionsInner client = this.manager().inner().workspaceCollections();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createParameter = new CreateWorkspaceCollectionRequest();
    }

    @Override
    public Object properties() {
        return this.inner().properties();
    }

    @Override
    public AzureSku sku() {
        return this.inner().sku();
    }

    @Override
    public WorkspaceCollectionImpl withSku(AzureSku sku) {
        this.createParameter.withSku(sku);
        return this;
    }

    @Override
    public WorkspaceCollectionImpl withTags(Map<String, String> tags) {
        this.utags = tags;
        return this;
    }

}
