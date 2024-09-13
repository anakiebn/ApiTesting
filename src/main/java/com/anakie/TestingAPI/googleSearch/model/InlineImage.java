package com.anakie.TestingAPI.backend.googleSearch.model;

import lombok.Data;

import java.util.List;

@Data
public class InlineImage {
    private List<Suggestion> suggestions;
}
