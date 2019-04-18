/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.contentmoderator.models;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Video frame property details.
 */
public class Frame {
    /**
     * Timestamp of the frame.
     */
    @JsonProperty(value = "Timestamp")
    private String timestamp;

    /**
     * Frame image.
     */
    @JsonProperty(value = "FrameImage")
    private String frameImage;

    /**
     * Array of KeyValue.
     */
    @JsonProperty(value = "Metadata")
    private List<KeyValuePair> metadata;

    /**
     * Reviewer result tags.
     */
    @JsonProperty(value = "ReviewerResultTags")
    private List<Tag> reviewerResultTags;

    /**
     * Get timestamp of the frame.
     *
     * @return the timestamp value
     */
    public String timestamp() {
        return this.timestamp;
    }

    /**
     * Set timestamp of the frame.
     *
     * @param timestamp the timestamp value to set
     * @return the Frame object itself.
     */
    public Frame withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get frame image.
     *
     * @return the frameImage value
     */
    public String frameImage() {
        return this.frameImage;
    }

    /**
     * Set frame image.
     *
     * @param frameImage the frameImage value to set
     * @return the Frame object itself.
     */
    public Frame withFrameImage(String frameImage) {
        this.frameImage = frameImage;
        return this;
    }

    /**
     * Get array of KeyValue.
     *
     * @return the metadata value
     */
    public List<KeyValuePair> metadata() {
        return this.metadata;
    }

    /**
     * Set array of KeyValue.
     *
     * @param metadata the metadata value to set
     * @return the Frame object itself.
     */
    public Frame withMetadata(List<KeyValuePair> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get reviewer result tags.
     *
     * @return the reviewerResultTags value
     */
    public List<Tag> reviewerResultTags() {
        return this.reviewerResultTags;
    }

    /**
     * Set reviewer result tags.
     *
     * @param reviewerResultTags the reviewerResultTags value to set
     * @return the Frame object itself.
     */
    public Frame withReviewerResultTags(List<Tag> reviewerResultTags) {
        this.reviewerResultTags = reviewerResultTags;
        return this;
    }

}
