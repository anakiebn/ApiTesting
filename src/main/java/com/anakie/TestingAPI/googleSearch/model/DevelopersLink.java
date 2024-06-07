package com.anakie.TestingAPI.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class DevelopersLink {
    private String text;
    private String link;
}

