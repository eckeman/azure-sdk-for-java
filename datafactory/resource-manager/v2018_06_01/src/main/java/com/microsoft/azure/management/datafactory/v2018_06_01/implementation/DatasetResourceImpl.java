/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01.implementation;

import com.microsoft.azure.management.datafactory.v2018_06_01.DatasetResource;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import java.util.Map;
import com.microsoft.azure.management.datafactory.v2018_06_01.LinkedServiceReference;
import com.microsoft.azure.management.datafactory.v2018_06_01.ParameterSpecification;
import java.util.List;
import com.microsoft.azure.management.datafactory.v2018_06_01.DatasetFolder;
import com.microsoft.azure.management.datafactory.v2018_06_01.;
import rx.functions.Func1;

class DatasetResourceImpl extends CreatableUpdatableImpl<DatasetResource, DatasetResourceInner, DatasetResourceImpl> implements DatasetResource, DatasetResource.Definition, DatasetResource.Update {
    private final DataFactoryManager manager;
    private String resourceGroupName;
    private String factoryName;
    private String datasetName;
    private String cifMatch;
    private DatasetInner cproperties;
    private String uifMatch;
    private DatasetInner uproperties;

    DatasetResourceImpl(String name, DataFactoryManager manager) {
        super(name, new DatasetResourceInner());
        this.manager = manager;
        // Set resource name
        this.datasetName = name;
        //
        this.cproperties = new DatasetInner();
        this.uproperties = new DatasetInner();
    }

    DatasetResourceImpl(DatasetResourceInner inner, DataFactoryManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.datasetName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.factoryName = IdParsingUtils.getValueFromIdByName(inner.id(), "factories");
        this.datasetName = IdParsingUtils.getValueFromIdByName(inner.id(), "datasets");
        //
        this.cproperties = new DatasetInner();
        this.uproperties = new DatasetInner();
    }

    @Override
    public DataFactoryManager manager() {
        return this.manager;
    }

    @Override
    public Observable<DatasetResource> createResourceAsync() {
        DatasetsInner client = this.manager().inner().datasets();
        return client.createOrUpdateAsync(this.resourceGroupName, this.factoryName, this.datasetName, this.cproperties, this.cifMatch)
            .map(new Func1<DatasetResourceInner, DatasetResourceInner>() {
               @Override
               public DatasetResourceInner call(DatasetResourceInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<DatasetResource> updateResourceAsync() {
        DatasetsInner client = this.manager().inner().datasets();
        return client.createOrUpdateAsync(this.resourceGroupName, this.factoryName, this.datasetName, this.uproperties, this.uifMatch)
            .map(new Func1<DatasetResourceInner, DatasetResourceInner>() {
               @Override
               public DatasetResourceInner call(DatasetResourceInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<DatasetResourceInner> getInnerAsync() {
        DatasetsInner client = this.manager().inner().datasets();
        return client.getAsync(this.resourceGroupName, this.factoryName, this.datasetName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.cproperties = new DatasetInner();
        this.uproperties = new DatasetInner();
    }

    @Override
    public String etag() {
        return this.inner().etag();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public DatasetInner properties() {
        return this.inner().properties();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public DatasetResourceImpl withExistingFactory(String resourceGroupName, String factoryName) {
        this.resourceGroupName = resourceGroupName;
        this.factoryName = factoryName;
        return this;
    }

    @Override
    public DatasetResourceImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.cifMatch = ifMatch;
        } else {
            this.uifMatch = ifMatch;
        }
        return this;
    }

    @Override
    public DatasetResourceImpl withProperties(DatasetInner properties) {
        if (isInCreateMode()) {
            this.cproperties = properties;
        } else {
            this.uproperties = properties;
        }
        return this;
    }

}
