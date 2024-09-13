package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class KnowledgeGraph {
    private String kgmid;
    private String knowledge_graph_type;
    public String title;
    private String type;
    private String description;
    private Source source;
    private String postal_code;
    private String lg_as;
    private List<LgAsLinks> lg_as_links;
    private String location;
    private String population;
    private List<LgAsLinks> population_links;
    private List<LgAsLinks> location_links;
    private String initial_release_date;
    private String developers;
    private List<DevelopersLink> developers_links;
    private String engine;
    private String license;
    private String platform;
    private String stable_release;
    private String written_in;
    private List<WrittenInLink> written_in_links;
    private List<PeopleAlsoSearchFor> people_also_search_for;
    private String image;
    private List<OrganicResult> organicResults;

    private String people_also_search_for_link;

}
