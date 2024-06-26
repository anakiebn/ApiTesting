package com.anakie.TestingAPI.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ImageResults {

    @JsonProperty
    private SearchMetadata search_metadata;

    @JsonProperty
    private String error;

    @JsonProperty
    private SearchParameters search_parameters;

    @JsonProperty
    private SearchInformation search_information;

    @JsonProperty
    private List<Suggestion> suggestions;

    @JsonProperty
    private List<Image> images;

    @JsonProperty
    private List<ShoppingAd> shopping_ads;
    @JsonProperty
    private List<RelatedSearch> related_searches;
}
