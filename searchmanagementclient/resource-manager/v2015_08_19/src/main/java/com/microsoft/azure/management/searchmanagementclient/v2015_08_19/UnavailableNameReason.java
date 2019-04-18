/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.searchmanagementclient.v2015_08_19;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for UnavailableNameReason.
 */
public final class UnavailableNameReason extends ExpandableStringEnum<UnavailableNameReason> {
    /** Static value Invalid for UnavailableNameReason. */
    public static final UnavailableNameReason INVALID = fromString("Invalid");

    /** Static value AlreadyExists for UnavailableNameReason. */
    public static final UnavailableNameReason ALREADY_EXISTS = fromString("AlreadyExists");

    /**
     * Creates or finds a UnavailableNameReason from its string representation.
     * @param name a name to look for
     * @return the corresponding UnavailableNameReason
     */
    @JsonCreator
    public static UnavailableNameReason fromString(String name) {
        return fromString(name, UnavailableNameReason.class);
    }

    /**
     * @return known UnavailableNameReason values
     */
    public static Collection<UnavailableNameReason> values() {
        return values(UnavailableNameReason.class);
    }
}
