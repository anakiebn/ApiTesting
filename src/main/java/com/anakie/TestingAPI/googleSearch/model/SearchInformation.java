package com.anakie.TestingAPI.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchInformation {

    private String query_displayed;
    private int total_results;
    private double time_taken_displayed;
    private String detected_location;
}
