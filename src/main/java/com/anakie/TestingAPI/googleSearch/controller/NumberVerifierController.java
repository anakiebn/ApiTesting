package com.anakie.TestingAPI.googleSearch.controller;

import com.anakie.TestingAPI.googleSearch.model.URIGenerator;
import com.anakie.TestingAPI.googleSearch.model.numberVerifierModel.CellNumber;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<CellNumber> verifyNumber(@PathVariable String number) {

        System.out.println("access: "+access);
        long validNumber = 0;
        try {
            validNumber = number.startsWith("+27") ? Long.parseLong("0" + number.substring(3)) : Long.parseLong(number);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        HttpClient client = HttpClient.newHttpClient();
        String message = null;

        String uri = baseURI+"?access_key=" +
                access + "&number=" + number + "&country_code=za&format=1";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(uri))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            CellNumber cellNumber = new ObjectMapper().readValue(response.body(), CellNumber.class);

            log.info("Number: {} is {}",cellNumber, cellNumber.isValid() ? "Your number is valid":"invalid number");


            return new ResponseEntity<>(cellNumber, HttpStatusCode.valueOf(response.statusCode()));

        } catch (URISyntaxException | IOException | InterruptedException e) {
            log.error(e.getMessage());

            throw new RuntimeException(e);
        }


    }


}

