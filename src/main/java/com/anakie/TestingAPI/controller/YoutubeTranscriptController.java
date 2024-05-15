package com.anakie.TestingAPI.controller;

import com.anakie.TestingAPI.model.URIGenerator;
import com.anakie.TestingAPI.model.youtubeModel.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/apiTest")
public class YoutubeTranscriptController implements URIGenerator {


    @Value("${searchApi.google.apikey}")
    private String apiKey;
    @Value("${searchAPI.googleImage.baseURI}")
    private String baseURI;
//    public ResponseEntity<Result> getTranscript(){
//
//
//        HttpClient client=HttpClient.newHttpClient();
//        HttpRequest request=HttpRequest.newBuilder().GET().uri(generateURI());
//
//
//
//        return new ResponseEntity<>();
//
//    }


}
