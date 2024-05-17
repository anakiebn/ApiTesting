package com.anakie.TestingAPI.controller;


import com.anakie.TestingAPI.model.URIGenerator;
import com.anakie.TestingAPI.model.googleModel.ImageResults;
import com.anakie.TestingAPI.model.googleModel.NewsResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/apiTest/googleImageSearch")
public class GoogleImageSearchController implements URIGenerator {
    @Value("${searchAPI.apikey}")
    private String apiKey;
    @Value("${searchAPI.baseURI}")
    private String baseURI;

    @GetMapping("/{query}")
    public ResponseEntity<ImageResults> getImages(@PathVariable String query) throws URISyntaxException, IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("ql","za");  // by default, I'm focused on south african content
        parameters.put("nfpr","1");  // set to 1, excludes autocorrected results
        parameters.put("safe","active"); // filter out adult content, enable safe browsing
        parameters.put("engine","google_images"); // image engine
        parameters.put("api_key",apiKey);
        parameters.put("google_domain","google.co.za"); // focused on SA results
        parameters.put("q",query);
        parameters.put("tbs","itp:face"); // we focus on faces.

        HttpClient client=  HttpClient.newHttpClient();


            log.info(generateURI(parameters,baseURI).toString());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(generateURI(parameters,baseURI))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            log.info(response.body());
            return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(), ImageResults.class), HttpStatus.valueOf(response.statusCode()));


    }

}
