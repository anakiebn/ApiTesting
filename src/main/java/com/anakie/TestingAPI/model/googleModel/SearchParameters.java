package com.anakie.TestingAPI.model.googleModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.ALWAYS)
@Data
public class SearchParameters {
    @JsonProperty("q")
    private String q;

    @JsonProperty("gl")
    private String gl;

    @JsonProperty("nfpr")
    private String nfpr;

    @JsonProperty("safe")
    private String safe;

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

    @JsonProperty("tbs")
    private String tbs;
}
