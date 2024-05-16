package com.anakie.TestingAPI.controller;


import com.anakie.TestingAPI.model.URIGenerator;
import com.anakie.TestingAPI.model.googleModel.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/apiTest/googleImageSearch")
public class GoogleImageSearch implements URIGenerator {
    @Value("${searchAPI.apikey}")
    private String apiKey;
    @Value("${searchAPI.googleImage.baseURI}")
    private String baseURI;

    @GetMapping("/{query}")
    public ResponseEntity<Result> result(@PathVariable String query) {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("ql","za");  // by default, I'm focused on south african content
        parameters.put("nfpr","1");  // set to 1, excludes autocorrected results
        parameters.put("safe","active"); // filter out adult content, enable safe browsing
        parameters.put("engine","google_images"); // image engine
        parameters.put("api_key",apiKey);
        parameters.put("q",query);

        HttpClient client=  HttpClient.newHttpClient();
        try {

            log.info(generateURI(parameters,baseURI).toString());

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(generateURI(parameters,baseURI))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            log.info(response.body());
            return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(), Result.class), HttpStatus.valueOf(response.statusCode()));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
