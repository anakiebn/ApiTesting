package com.anakie.TestingAPI.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class Source {
    private String name;
    private String link;
    private String type;
    private String description;
    private String link_source;
    private String favicon;
    private String title;
    private String domain;
    private String displayed_link;
}
