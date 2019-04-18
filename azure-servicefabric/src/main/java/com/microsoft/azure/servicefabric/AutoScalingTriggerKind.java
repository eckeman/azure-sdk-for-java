/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for AutoScalingTriggerKind.
 */
public final class AutoScalingTriggerKind extends ExpandableStringEnum<AutoScalingTriggerKind> {
    /** Static value AverageLoad for AutoScalingTriggerKind. */
    public static final AutoScalingTriggerKind AVERAGE_LOAD = fromString("AverageLoad");

    /**
     * Creates or finds a AutoScalingTriggerKind from its string representation.
     * @param name a name to look for
     * @return the corresponding AutoScalingTriggerKind
     */
    @JsonCreator
    public static AutoScalingTriggerKind fromString(String name) {
        return fromString(name, AutoScalingTriggerKind.class);
    }

    /**
     * @return known AutoScalingTriggerKind values
     */
    public static Collection<AutoScalingTriggerKind> values() {
        return values(AutoScalingTriggerKind.class);
    }
}
