/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 1.0.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2016_06_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for RetentionDurationType.
 */
public enum RetentionDurationType {
    /** Enum value Invalid. */
    INVALID("Invalid"),

    /** Enum value Days. */
    DAYS("Days"),

    /** Enum value Weeks. */
    WEEKS("Weeks"),

    /** Enum value Months. */
    MONTHS("Months"),

    /** Enum value Years. */
    YEARS("Years");

    /** The actual serialized value for a RetentionDurationType instance. */
    private String value;

    RetentionDurationType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a RetentionDurationType instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed RetentionDurationType object, or null if unable to parse.
     */
    @JsonCreator
    public static RetentionDurationType fromString(String value) {
        RetentionDurationType[] items = RetentionDurationType.values();
        for (RetentionDurationType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
