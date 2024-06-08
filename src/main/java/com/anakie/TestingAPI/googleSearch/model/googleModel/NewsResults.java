package com.anakie.TestingAPI.googleSearch.model.googleModel;


import java.util.List;

public class NewsResults {

    public SearchMetadata search_metadata;
    public SearchParameters search_parameters;
    public SearchInformation search_information;
    public List<OrganicResult> organic_results;
    public List<TopStory> top_stories;
    public TopStoriesMoreLink top_stories_more_link;
    public Pagination pagination;

    public String error;

}