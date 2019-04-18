/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.powerbi.v2016_01_29.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.powerbi.v2016_01_29.Workspaces;
import rx.Observable;
import rx.functions.Func1;
import java.util.List;
import com.microsoft.azure.management.powerbi.v2016_01_29.Workspace;

class WorkspacesImpl extends WrapperImpl<WorkspacesInner> implements Workspaces {
    private final PowerBIManager manager;

    WorkspacesImpl(PowerBIManager manager) {
        super(manager.inner().workspaces());
        this.manager = manager;
    }

    public PowerBIManager manager() {
        return this.manager;
    }

    private WorkspaceImpl wrapModel(WorkspaceInner inner) {
        return  new WorkspaceImpl(inner, manager());
    }

    @Override
    public Observable<Workspace> listAsync(String resourceGroupName, String workspaceCollectionName) {
        WorkspacesInner client = this.inner();
        return client.listAsync(resourceGroupName, workspaceCollectionName)
        .flatMap(new Func1<List<WorkspaceInner>, Observable<WorkspaceInner>>() {
            @Override
            public Observable<WorkspaceInner> call(List<WorkspaceInner> innerList) {
                return Observable.from(innerList);
            }
        })
        .map(new Func1<WorkspaceInner, Workspace>() {
            @Override
            public Workspace call(WorkspaceInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
