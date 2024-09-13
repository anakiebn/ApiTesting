package com.anakie.TestingAPI.googleSearch.model.googleModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Image {


        @JsonProperty("position")
        private int position;

        @JsonProperty("title")
        private String title;

        @JsonProperty("source")
        private Source source;

        @JsonProperty("original")
        private Original original;

        @JsonProperty("thumbnail")
        private String thumbnail;




}
