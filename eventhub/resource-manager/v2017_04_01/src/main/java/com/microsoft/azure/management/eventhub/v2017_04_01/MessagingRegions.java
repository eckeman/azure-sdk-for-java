/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.eventhub.v2017_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.eventhub.v2017_04_01.implementation.EventHubManager;
import com.microsoft.azure.management.eventhub.v2017_04_01.implementation.MessagingRegionsInner;
import java.util.Map;

/**
 * Type representing MessagingRegions.
 */
public interface MessagingRegions extends HasInner<MessagingRegionsInner>, HasManager<EventHubManager> {
    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the properties value.
     */
    MessagingRegionsProperties properties();

    /**
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * @return the type value.
     */
    String type();

}
