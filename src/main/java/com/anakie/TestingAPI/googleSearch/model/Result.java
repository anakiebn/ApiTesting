package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    private InlineImages inline_images;
    private Link inline_images_more_links;
    private SearchMetadata search_metadata;
    private SearchParameters search_parameters;
    private SearchInformation search_information;
    private KnowledgeGraph knowledge_graph;
    private List<OrganicResult> organic_results;
    private List<RelatedQuestion> related_questions;
    private List<RelatedSearch> related_searches;
    private Pagination pagination;
}
