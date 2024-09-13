package com.anakie.TestingAPI.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchMetadata {

    private String id;
    private String status;
    private LocalDate created_at;
    private double request_time_taken;
    private double parsing_time_taken;
    private double total_time_taken;
    private String request_url;
    private String html_url;
    private String json_url;
}
