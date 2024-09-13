package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class SearchParameters {

    private String engine;
    private String q;
    private String google_domain;
    private String hl;
    private String gl;
    private String device;
    private String location;
    private String safe;
    private String location_used;


}
