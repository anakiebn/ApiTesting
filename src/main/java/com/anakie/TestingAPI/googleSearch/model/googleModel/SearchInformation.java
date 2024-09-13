package com.anakie.TestingAPI.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchInformation {

    @JsonProperty("query_displayed")
    private String query_displayed;


    @JsonProperty("total_results")
    private Long total_results;

    @JsonProperty("time_taken_displayed")
    private Double time_taken_displayed;

    @JsonProperty("detected_location")
    private String detected_location;


}
