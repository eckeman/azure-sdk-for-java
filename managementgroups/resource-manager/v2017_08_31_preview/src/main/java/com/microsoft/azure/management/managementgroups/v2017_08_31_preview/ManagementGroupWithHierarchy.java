/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.managementgroups.v2017_08_31_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.managementgroups.v2017_08_31_preview.implementation.ManagementManager;
import com.microsoft.azure.management.managementgroups.v2017_08_31_preview.implementation.ManagementGroupWithHierarchyInner;
import java.util.List;
import java.util.UUID;

/**
 * Type representing ManagementGroupWithHierarchy.
 */
public interface ManagementGroupWithHierarchy extends HasInner<ManagementGroupWithHierarchyInner>, HasManager<ManagementManager> {
    /**
     * @return the children value.
     */
    List<ManagementGroupRecursiveChildInfo> children();

    /**
     * @return the details value.
     */
    ManagementGroupDetailsProperties details();

    /**
     * @return the displayName value.
     */
    String displayName();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the name value.
     */
    UUID name();

    /**
     * @return the tenantId value.
     */
    UUID tenantId();

    /**
     * @return the type value.
     */
    String type();

}
