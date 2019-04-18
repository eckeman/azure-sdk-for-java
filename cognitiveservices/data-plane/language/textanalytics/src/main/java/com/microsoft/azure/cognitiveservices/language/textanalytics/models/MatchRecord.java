/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.textanalytics.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The MatchRecord model.
 */
public class MatchRecord {
    /**
     * (optional) If a well-known item with Wikipedia link is recognized, a
     * decimal number denoting the confidence level of the Wikipedia info will
     * be returned.
     */
    @JsonProperty(value = "wikipediaScore")
    private Double wikipediaScore;

    /**
     * (optional) If an entity type is recognized, a decimal number denoting
     * the confidence level of the entity type will be returned.
     */
    @JsonProperty(value = "entityTypeScore")
    private Double entityTypeScore;

    /**
     * Entity text as appears in the request.
     */
    @JsonProperty(value = "text")
    private String text;

    /**
     * Start position (in Unicode characters) for the entity match text.
     */
    @JsonProperty(value = "offset")
    private Integer offset;

    /**
     * Length (in Unicode characters) for the entity match text.
     */
    @JsonProperty(value = "length")
    private Integer length;

    /**
     * Get (optional) If a well-known item with Wikipedia link is recognized, a decimal number denoting the confidence level of the Wikipedia info will be returned.
     *
     * @return the wikipediaScore value
     */
    public Double wikipediaScore() {
        return this.wikipediaScore;
    }

    /**
     * Set (optional) If a well-known item with Wikipedia link is recognized, a decimal number denoting the confidence level of the Wikipedia info will be returned.
     *
     * @param wikipediaScore the wikipediaScore value to set
     * @return the MatchRecord object itself.
     */
    public MatchRecord withWikipediaScore(Double wikipediaScore) {
        this.wikipediaScore = wikipediaScore;
        return this;
    }

    /**
     * Get (optional) If an entity type is recognized, a decimal number denoting the confidence level of the entity type will be returned.
     *
     * @return the entityTypeScore value
     */
    public Double entityTypeScore() {
        return this.entityTypeScore;
    }

    /**
     * Set (optional) If an entity type is recognized, a decimal number denoting the confidence level of the entity type will be returned.
     *
     * @param entityTypeScore the entityTypeScore value to set
     * @return the MatchRecord object itself.
     */
    public MatchRecord withEntityTypeScore(Double entityTypeScore) {
        this.entityTypeScore = entityTypeScore;
        return this;
    }

    /**
     * Get entity text as appears in the request.
     *
     * @return the text value
     */
    public String text() {
        return this.text;
    }

    /**
     * Set entity text as appears in the request.
     *
     * @param text the text value to set
     * @return the MatchRecord object itself.
     */
    public MatchRecord withText(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get start position (in Unicode characters) for the entity match text.
     *
     * @return the offset value
     */
    public Integer offset() {
        return this.offset;
    }

    /**
     * Set start position (in Unicode characters) for the entity match text.
     *
     * @param offset the offset value to set
     * @return the MatchRecord object itself.
     */
    public MatchRecord withOffset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * Get length (in Unicode characters) for the entity match text.
     *
     * @return the length value
     */
    public Integer length() {
        return this.length;
    }

    /**
     * Set length (in Unicode characters) for the entity match text.
     *
     * @param length the length value to set
     * @return the MatchRecord object itself.
     */
    public MatchRecord withLength(Integer length) {
        this.length = length;
        return this;
    }

}
