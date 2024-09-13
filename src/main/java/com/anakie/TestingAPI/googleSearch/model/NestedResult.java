package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class NestedResult {
    private int position;
    private String title;
    private String link;
    private String domain;
    private String displayed_link;
    private String snippet;
    private List<String> snippet_highlighted_words;
    private AboutThisResult about_this_result;
    private String about_page_link;
    private String cached_page_link;
}
