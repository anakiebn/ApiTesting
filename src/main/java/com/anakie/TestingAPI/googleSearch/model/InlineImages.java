package com.anakie.TestingAPI.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class InlineImages {
    private List<Suggestion> suggestions;
}
