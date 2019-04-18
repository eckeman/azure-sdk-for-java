/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.powerbi.v2016_01_29.implementation;

import com.microsoft.azure.management.powerbi.v2016_01_29.CheckNameReason;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The CheckNameResponseInner model.
 */
public class CheckNameResponseInner {
    /**
     * Specifies a Boolean value that indicates whether the specified Power BI
     * Workspace Collection name is available to use.
     */
    @JsonProperty(value = "nameAvailable")
    private Boolean nameAvailable;

    /**
     * Reason why the workspace collection name cannot be used. Possible values
     * include: 'Unavailable', 'Invalid'.
     */
    @JsonProperty(value = "reason")
    private CheckNameReason reason;

    /**
     * Message indicating an unavailable name due to a conflict, or a
     * description of the naming rules that are violated.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * Get specifies a Boolean value that indicates whether the specified Power BI Workspace Collection name is available to use.
     *
     * @return the nameAvailable value
     */
    public Boolean nameAvailable() {
        return this.nameAvailable;
    }

    /**
     * Set specifies a Boolean value that indicates whether the specified Power BI Workspace Collection name is available to use.
     *
     * @param nameAvailable the nameAvailable value to set
     * @return the CheckNameResponseInner object itself.
     */
    public CheckNameResponseInner withNameAvailable(Boolean nameAvailable) {
        this.nameAvailable = nameAvailable;
        return this;
    }

    /**
     * Get reason why the workspace collection name cannot be used. Possible values include: 'Unavailable', 'Invalid'.
     *
     * @return the reason value
     */
    public CheckNameReason reason() {
        return this.reason;
    }

    /**
     * Set reason why the workspace collection name cannot be used. Possible values include: 'Unavailable', 'Invalid'.
     *
     * @param reason the reason value to set
     * @return the CheckNameResponseInner object itself.
     */
    public CheckNameResponseInner withReason(CheckNameReason reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get message indicating an unavailable name due to a conflict, or a description of the naming rules that are violated.
     *
     * @return the message value
     */
    public String message() {
        return this.message;
    }

    /**
     * Set message indicating an unavailable name due to a conflict, or a description of the naming rules that are violated.
     *
     * @param message the message value to set
     * @return the CheckNameResponseInner object itself.
     */
    public CheckNameResponseInner withMessage(String message) {
        this.message = message;
        return this;
    }

}
