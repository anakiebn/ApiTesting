package com.anakie.TestingAPI.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result {

    @JsonProperty
    public SearchMetadata search_metadata;

    @JsonProperty
    public SearchParameters search_parameters;

    @JsonProperty
    public SearchInformation search_information;

    @JsonProperty
    public List<Suggestion> suggestions;

    @JsonProperty
    public List<Image> images;

    @JsonProperty
    public List<ShoppingAd> shopping_ads;
    @JsonProperty
    public List<RelatedSearch> related_searches;
}
