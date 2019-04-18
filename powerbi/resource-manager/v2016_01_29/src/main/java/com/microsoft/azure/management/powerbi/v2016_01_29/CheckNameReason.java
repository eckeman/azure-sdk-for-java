/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.powerbi.v2016_01_29;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for CheckNameReason.
 */
public final class CheckNameReason extends ExpandableStringEnum<CheckNameReason> {
    /** Static value Unavailable for CheckNameReason. */
    public static final CheckNameReason UNAVAILABLE = fromString("Unavailable");

    /** Static value Invalid for CheckNameReason. */
    public static final CheckNameReason INVALID = fromString("Invalid");

    /**
     * Creates or finds a CheckNameReason from its string representation.
     * @param name a name to look for
     * @return the corresponding CheckNameReason
     */
    @JsonCreator
    public static CheckNameReason fromString(String name) {
        return fromString(name, CheckNameReason.class);
    }

    /**
     * @return known CheckNameReason values
     */
    public static Collection<CheckNameReason> values() {
        return values(CheckNameReason.class);
    }
}
