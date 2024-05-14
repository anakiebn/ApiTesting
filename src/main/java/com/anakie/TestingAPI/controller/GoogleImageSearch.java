package com.anakie.TestingAPI.controller;


import com.anakie.TestingAPI.model.googleModel.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/googleImageSearch")
public class GoogleImageSearch {
    @Value("${searchApi.google.apikey}")
    private String apiKey;

    @GetMapping("/{query}")
    public ResponseEntity<Result> result(@PathVariable String query) {


        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_key",apiKey);
        parameters.put("q",query);
        parameters.put("ql","za");  // by default, I'm focused on south african content
        parameters.put("nfpr","1");  // set to 1, excludes autocorrected results
        parameters.put("safe","active"); // filter out adult content, enable safe browsing
        parameters.put("engine","google_images"); // image engine


        HttpClient client=  HttpClient.newHttpClient();
        try {

            log.info(generateURI(parameters).toString());


            HttpRequest request = HttpRequest.newBuilder()
                    .uri(generateURI(parameters))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            log.info(response.body());
            return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(), Result.class), HttpStatus.valueOf(response.statusCode()));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    private URI generateURI(Map<String, String> parameters) throws URISyntaxException {

        StringBuilder generatedURI = new StringBuilder("https://www.searchapi.io/api/v1/search?");

        int count = 0;
        for (String name : parameters.keySet()) {
            String value = parameters.get(name);

            count++;

            generatedURI.append(name).append("=").append(value);
            if (count < parameters.size()) {
                generatedURI.append("&");
            }

        }

        return new URI(generatedURI.toString());
    }
}
