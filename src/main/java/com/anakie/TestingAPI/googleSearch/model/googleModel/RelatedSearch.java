package com.anakie.TestingAPI.backend.googleSearch.model.googleModel;

import lombok.Data;

import java.util.List;

@Data
public class RelatedSearch {

    private String link;
    private String query;
    private List<String> highlighted;
    private String thumbnail;
}
