package com.anakie.TestingAPI.backend.googleSearch.model.youtubeModel;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    public String error;
    public SearchMetadata search_metadata;
    public SearchParameters search_parameters;
    public List<Transcript> transcripts;
    public List<AvailableLanguage> available_languages;

}
