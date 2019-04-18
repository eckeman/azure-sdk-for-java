/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 1.0.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 * abc
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.ExportJobsOperationResults;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.OperationResultInfoBaseResource;

class ExportJobsOperationResultsImpl extends WrapperImpl<ExportJobsOperationResultsInner> implements ExportJobsOperationResults {
    private final RecoveryServicesManager manager;

    ExportJobsOperationResultsImpl(RecoveryServicesManager manager) {
        super(manager.inner().exportJobsOperationResults());
        this.manager = manager;
    }

    public RecoveryServicesManager manager() {
        return this.manager;
    }

    @Override
    public Observable<OperationResultInfoBaseResource> getAsync(String vaultName, String resourceGroupName, String operationId) {
        ExportJobsOperationResultsInner client = this.inner();
        return client.getAsync(vaultName, resourceGroupName, operationId)
        .map(new Func1<OperationResultInfoBaseResourceInner, OperationResultInfoBaseResource>() {
            @Override
            public OperationResultInfoBaseResource call(OperationResultInfoBaseResourceInner inner) {
                return new OperationResultInfoBaseResourceImpl(inner, manager());
            }
        });
    }

}
