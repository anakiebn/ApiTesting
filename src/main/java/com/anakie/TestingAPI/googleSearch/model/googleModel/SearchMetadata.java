package com.anakie.TestingAPI.backend.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SearchMetadata {

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("created_at")
    private LocalDate createdAt;

    @JsonProperty("request_time_taken")
    private double requestTimeTaken;

    @JsonProperty("parsing_time_taken")
    private double parsingTimeTaken;

    @JsonProperty("total_time_taken")
    private double totalTimeTaken;

    @JsonProperty("request_url")
    private String requestUrl;

    @JsonProperty("html_url")
    private String htmlUrl;

    @JsonProperty("json_url")
    private String jsonUrl;
}
