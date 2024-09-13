package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Suggestion {
    private String title;
    private String link;
    private String thumbnail;
    private String chips;
    private String suggestions;
}


