/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.commerce.v2015_06_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.microsoft.azure.management.commerce.v2015_06_01_preview.implementation.OfferTermInfoInner;

/**
 * Indicates a recurring charge is present for this offer.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Name")
@JsonTypeName("Recurring Charge")
public class RecurringCharge extends OfferTermInfoInner {
    /**
     * The amount of recurring charge as per the offer term.
     */
    @JsonProperty(value = "RecurringCharge")
    private Integer recurringCharge;

    /**
     * Get the amount of recurring charge as per the offer term.
     *
     * @return the recurringCharge value
     */
    public Integer recurringCharge() {
        return this.recurringCharge;
    }

    /**
     * Set the amount of recurring charge as per the offer term.
     *
     * @param recurringCharge the recurringCharge value to set
     * @return the RecurringCharge object itself.
     */
    public RecurringCharge withRecurringCharge(Integer recurringCharge) {
        this.recurringCharge = recurringCharge;
        return this;
    }

}
