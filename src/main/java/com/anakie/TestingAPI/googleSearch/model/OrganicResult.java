package com.anakie.TestingAPI.backend.googleSearch.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class OrganicResult {

    private int position;
    private String source;
    private String title;
    private String link;
    private String domain;
    private String displayed_link;
    private String snippet;
    private List<String> snippet_highlighted_words;
    private String date;
    private Sitelinks sitelinks;
    private AboutThisResult about_this_result;
    private String about_page_link;
    private String cached_page_link;
    private String favicon;
    private String thumbnail;
    private List<NestedResult> nested_results;
    private RichSnippet rich_snippet;

}
