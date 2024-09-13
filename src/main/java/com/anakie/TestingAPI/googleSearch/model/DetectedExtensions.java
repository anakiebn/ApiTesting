package com.anakie.TestingAPI.backend.googleSearch.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class DetectedExtensions {

    private double rating;
    private int reviews;
    private List<Question> questions;
}
