package com.anakie.TestingAPI.googleSearch.model.numberVerifierModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Error {

    public int code;
    public String type;
    public String info;
}
