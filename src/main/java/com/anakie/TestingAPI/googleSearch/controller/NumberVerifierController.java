package com.anakie.TestingAPI.googleSearch.controller;

import com.anakie.TestingAPI.googleSearch.model.URIGenerator;
import com.anakie.TestingAPI.googleSearch.model.numberVerifierModel.CellNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RestController
@RequestMapping("apiTesting/verify")
public class NumberVerifierController implements URIGenerator {
    @Value("${apiLayer.baseURI}")
    private String baseURI;

    @Value("${apiLayer.access_key}")
    private String access;

    @GetMapping("/{number}")
    public ResponseEntity<CellNumber> verifyNumber(@PathVariable String number) throws URISyntaxException, IOException, InterruptedException {

        long validNumber;
        try {
            validNumber = number.startsWith("+27") ? Long.parseLong("0" + number.substring(3)) : Long.parseLong(number);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        HttpClient client = HttpClient.newHttpClient();
        String uri = baseURI + "api_key=" + access + "&number=" + number + "&country_code=za&format=1";
        log.info("URI: {}", uri);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        HttpStatus httpStatus = HttpStatus.valueOf(response.statusCode());

        switch (httpStatus) {
            case OK -> {
                CellNumber cellNumber = new ObjectMapper().readValue(response.body(), CellNumber.class);
                log.info("Number: {} is {}", cellNumber, cellNumber.isValid() ? "valid" : "invalid");
                return new ResponseEntity<>(cellNumber, HttpStatus.OK);
            }
            case BAD_REQUEST ->
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The request was unacceptable, often due to missing a required parameter.");
            case UNAUTHORIZED ->
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No valid API key provided.");
            case NOT_FOUND ->
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The requested resource doesn't exist.");
            case TOO_MANY_REQUESTS ->
                    throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS, "API request limit exceeded. See section Rate Limiting for more info.");
            default ->
                    throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "We have failed to process your request. (You can contact us anytime)");
        }
    }
}
