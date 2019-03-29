/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.hanaonazure.v2017_11_03_preview;

import rx.Completable;
import com.microsoft.azure.management.hanaonazure.v2017_11_03_preview.implementation.MonitoringsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Monitorings.
 */
public interface Monitorings extends HasInner<MonitoringsInner> {
    /**
     * The operation to monitor a SAP HANA instance.
     *
     * @param resourceGroupName Name of the resource group.
     * @param hanaInstanceName Name of the SAP HANA on Azure instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Completable hanaInstancesMethodAsync(String resourceGroupName, String hanaInstanceName);

}
