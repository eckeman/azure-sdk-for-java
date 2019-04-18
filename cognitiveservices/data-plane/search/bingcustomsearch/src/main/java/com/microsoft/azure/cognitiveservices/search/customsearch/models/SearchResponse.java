/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.search.customsearch.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Defines the top-level object that the response includes when the request
 * succeeds.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_type")
@JsonTypeName("SearchResponse")
public class SearchResponse extends Response {
    /**
     * An object that contains the query string that Bing used for the request.
     * This object contains the query string as entered by the user. It may
     * also contain an altered query string that Bing used for the query if the
     * query string contained a spelling mistake.
     */
    @JsonProperty(value = "queryContext", access = JsonProperty.Access.WRITE_ONLY)
    private QueryContext queryContext;

    /**
     * A list of webpages that are relevant to the search query.
     */
    @JsonProperty(value = "webPages", access = JsonProperty.Access.WRITE_ONLY)
    private WebWebAnswer webPages;

    /**
     * Get an object that contains the query string that Bing used for the request. This object contains the query string as entered by the user. It may also contain an altered query string that Bing used for the query if the query string contained a spelling mistake.
     *
     * @return the queryContext value
     */
    public QueryContext queryContext() {
        return this.queryContext;
    }

    /**
     * Get a list of webpages that are relevant to the search query.
     *
     * @return the webPages value
     */
    public WebWebAnswer webPages() {
        return this.webPages;
    }

}
