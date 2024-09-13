package com.anakie.TestingAPI.googleSearch.controller;


import com.anakie.TestingAPI.googleSearch.model.Result;
import com.anakie.TestingAPI.googleSearch.model.URIGenerator;
import com.anakie.TestingAPI.googleSearch.service.GoogleSearchServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@RestController
@RequestMapping("/apiTest/googleSearch")
public class GoogleSearchController implements URIGenerator {

    @Value("${searchAPI.apikey}")
    private String apiKey;

    @Value("${searchAPI.baseURI}")
    private String baseURI;
    private final HttpClient client;


    private final GoogleSearchServiceImpl googleSearchService;

    public GoogleSearchController(GoogleSearchServiceImpl googleSearchService) {
        this.googleSearchService = googleSearchService;
        client = HttpClient.newHttpClient();
    }

    @GetMapping("/{query}")
    public ResponseEntity<Result> getResult(@PathVariable String query) throws URISyntaxException, IOException, InterruptedException {
        String rawQuery = "\"" + query + "\"  -city -town -state -restaurant -hotel";

        // URL-encode the query string
        String encodedQuery = URLEncoder.encode(rawQuery, StandardCharsets.UTF_8);

        Map<String, String> parameters = new HashMap<>();
        parameters.put("q", encodedQuery);   // q for query
        parameters.put("device", "desktop");
//        parameters.put("google_domain", "google.com");
        parameters.put("engine","google");
        parameters.put("api_key",apiKey);
        parameters.put("gl", "za");
        parameters.put("safe", "active");
        parameters.put("location","south+africa");

        final HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(generateURI(parameters, baseURI.trim()))
                .build();
        final HttpResponse<String> response =client.send(request,HttpResponse.BodyHandlers.ofString());

        log.info(response.body());
        final int code=response.statusCode();
        return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(),Result.class), HttpStatusCode.valueOf(code));
    }


}
