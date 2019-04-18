/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.hanaonazure.v2017_11_03_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.hanaonazure.v2017_11_03_preview.implementation.HanaOnAzureManager;
import java.util.Map;
import com.microsoft.azure.management.hanaonazure.v2017_11_03_preview.implementation.HanaInstanceInner;

/**
 * Type representing HanaInstance.
 */
public interface HanaInstance extends HasInner<HanaInstanceInner>, Resource, GroupableResourceCore<HanaOnAzureManager, HanaInstanceInner>, HasResourceGroup, Refreshable<HanaInstance>, Updatable<HanaInstance.Update>, HasManager<HanaOnAzureManager> {
    /**
     * @return the hanaInstanceId value.
     */
    String hanaInstanceId();

    /**
     * @return the hardwareProfile value.
     */
    HardwareProfile hardwareProfile();

    /**
     * @return the hwRevision value.
     */
    String hwRevision();

    /**
     * @return the networkProfile value.
     */
    NetworkProfile networkProfile();

    /**
     * @return the osProfile value.
     */
    OSProfile osProfile();

    /**
     * @return the powerState value.
     */
    HanaInstancePowerStateEnum powerState();

    /**
     * @return the proximityPlacementGroup value.
     */
    String proximityPlacementGroup();

    /**
     * @return the storageProfile value.
     */
    StorageProfile storageProfile();

    /**
     * The template for a HanaInstance update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<HanaInstance>, Resource.UpdateWithTags<Update>, UpdateStages.WithTags {
    }

    /**
     * Grouping of HanaInstance update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the hanainstance update allowing to specify Tags.
         */
        interface WithTags {
            /**
             * Specifies tags.
             * @param tags Tags field of the HANA instance
             * @return the next update stage
             */
            Update withTags(Map<String, String> tags);
        }

    }
}
