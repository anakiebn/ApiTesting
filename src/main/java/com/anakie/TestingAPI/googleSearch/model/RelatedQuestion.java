package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class RelatedQuestion {
    private String question;
    private String answer;
    private String answer_highlight;
    private Source source;
    private Search search;
}
