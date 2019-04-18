/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.search.videosearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * The VideoDetails model.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_type")
@JsonTypeName("VideoDetails")
public class VideoDetails extends Response {
    /**
     * The relatedVideos property.
     */
    @JsonProperty(value = "relatedVideos", access = JsonProperty.Access.WRITE_ONLY)
    private VideosModule relatedVideos;

    /**
     * The videoResult property.
     */
    @JsonProperty(value = "videoResult", access = JsonProperty.Access.WRITE_ONLY)
    private VideoObject videoResult;

    /**
     * Get the relatedVideos value.
     *
     * @return the relatedVideos value
     */
    public VideosModule relatedVideos() {
        return this.relatedVideos;
    }

    /**
     * Get the videoResult value.
     *
     * @return the videoResult value
     */
    public VideoObject videoResult() {
        return this.videoResult;
    }

}
