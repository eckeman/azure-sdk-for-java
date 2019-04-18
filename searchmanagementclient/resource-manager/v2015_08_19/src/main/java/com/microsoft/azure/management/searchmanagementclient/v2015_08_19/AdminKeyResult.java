/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.searchmanagementclient.v2015_08_19;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.searchmanagementclient.v2015_08_19.implementation.SearchManager;
import com.microsoft.azure.management.searchmanagementclient.v2015_08_19.implementation.AdminKeyResultInner;

/**
 * Type representing AdminKeyResult.
 */
public interface AdminKeyResult extends HasInner<AdminKeyResultInner>, HasManager<SearchManager> {
    /**
     * @return the primaryKey value.
     */
    String primaryKey();

    /**
     * @return the secondaryKey value.
     */
    String secondaryKey();

}
