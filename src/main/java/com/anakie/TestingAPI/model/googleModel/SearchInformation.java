package com.anakie.TestingAPI.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SearchInformation {

    @JsonProperty("query_displayed")
    private String query_displayed;

}
