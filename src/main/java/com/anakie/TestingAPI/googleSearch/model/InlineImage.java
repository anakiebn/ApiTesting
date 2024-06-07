package com.anakie.TestingAPI.googleSearch.model;

import lombok.Data;

import java.util.List;

@Data
public class InlineImage {
    private List<Suggestion> suggestions;
}
