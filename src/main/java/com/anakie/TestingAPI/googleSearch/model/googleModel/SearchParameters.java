package com.anakie.TestingAPI.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class SearchParameters {
    @JsonProperty("q")
    private String q;
    @JsonProperty("country")
    private String country;
    @JsonProperty("as_dt")
    private String as_dt;

    @JsonProperty("inurl")
    private String inurl;


    @JsonProperty("gl")
    private String gl;

    @JsonProperty("nfpr")
    private String nfpr;

    @JsonProperty("safe")
    private String safe;

    @JsonProperty("time_period_min")
    private String time_period_min;

    @JsonProperty("time_period_max")
    private String time_period_max;

    @JsonProperty("engine")
    private String engine;

    @JsonProperty("uule")
    private String uule;

    @JsonProperty("location")
    private String location;

    @JsonProperty("location_used")
    private String locationUsed;

    @JsonProperty("google_domain")
    private String googleDomain;

    @JsonProperty("hl")
    private String hl;

    @JsonProperty("device")
    private String device;

    @JsonProperty("cr")
    private String cr;


    @JsonProperty("tbs")
    private String tbs;
}
