package com.anakie.TestingAPI.model.googleModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.ALWAYS)
public class SearchParameters {

    public String q;

    public String gl;

    public String nfpr;

    public String safe;
    public String engine;


    public String uule;
    public String location;
    public String location_used;
    public String google_domain;
    public String hl;

    public String device;

}
