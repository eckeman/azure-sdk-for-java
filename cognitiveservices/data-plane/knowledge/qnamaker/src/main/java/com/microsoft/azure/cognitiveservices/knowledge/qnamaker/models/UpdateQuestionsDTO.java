/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.knowledge.qnamaker.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * PATCH Body schema for Update Kb which contains list of questions to be added
 * and deleted.
 */
public class UpdateQuestionsDTO {
    /**
     * List of questions to be added.
     */
    @JsonProperty(value = "add")
    private List<String> add;

    /**
     * List of questions to be deleted.
     */
    @JsonProperty(value = "delete")
    private List<String> delete;

    /**
     * Get list of questions to be added.
     *
     * @return the add value
     */
    public List<String> add() {
        return this.add;
    }

    /**
     * Set list of questions to be added.
     *
     * @param add the add value to set
     * @return the UpdateQuestionsDTO object itself.
     */
    public UpdateQuestionsDTO withAdd(List<String> add) {
        this.add = add;
        return this;
    }

    /**
     * Get list of questions to be deleted.
     *
     * @return the delete value
     */
    public List<String> delete() {
        return this.delete;
    }

    /**
     * Set list of questions to be deleted.
     *
     * @param delete the delete value to set
     * @return the UpdateQuestionsDTO object itself.
     */
    public UpdateQuestionsDTO withDelete(List<String> delete) {
        this.delete = delete;
        return this;
    }

}
