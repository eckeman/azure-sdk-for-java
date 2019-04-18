/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.powerbi.v2016_01_29;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.powerbi.v2016_01_29.implementation.WorkspaceInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.powerbi.v2016_01_29.implementation.PowerBIManager;

/**
 * Type representing Workspace.
 */
public interface Workspace extends HasInner<WorkspaceInner>, HasManager<PowerBIManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    Object properties();

    /**
     * @return the type value.
     */
    String type();

}
