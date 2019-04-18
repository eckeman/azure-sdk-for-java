/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 1.0.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.implementation;

import com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.BackupFabricVaultProtectionContainerResource;
import com.microsoft.azure.arm.model.implementation.IndexableRefreshableWrapperImpl;
import rx.Observable;
import com.microsoft.azure.management.recoveryservices.backup.v2016_06_01.;
import java.util.Map;

class BackupFabricVaultProtectionContainerResourceImpl extends IndexableRefreshableWrapperImpl<BackupFabricVaultProtectionContainerResource, ProtectionContainerResourceInner> implements BackupFabricVaultProtectionContainerResource {
    private final RecoveryServicesManager manager;
    private String vaultName;
    private String resourceGroupName;
    private String fabricName;
    private String containerName;

    BackupFabricVaultProtectionContainerResourceImpl(ProtectionContainerResourceInner inner,  RecoveryServicesManager manager) {
        super(null, inner);
        this.manager = manager;
        // set resource ancestor and positional variables
        this.vaultName = IdParsingUtils.getValueFromIdByName(inner.id(), "vaults");
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.fabricName = IdParsingUtils.getValueFromIdByName(inner.id(), "backupFabrics");
        this.containerName = IdParsingUtils.getValueFromIdByName(inner.id(), "protectionContainers");
    }

    @Override
    public RecoveryServicesManager manager() {
        return this.manager;
    }

    @Override
    protected Observable<ProtectionContainerResourceInner> getInnerAsync() {
        ProtectionContainersInner client = this.manager().inner().protectionContainers();
        return client.getAsync(this.vaultName, this.resourceGroupName, this.fabricName, this.containerName);
    }



    @Override
    public String eTag() {
        return this.inner().eTag();
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
    public ProtectionContainerInner properties() {
        return this.inner().properties();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
