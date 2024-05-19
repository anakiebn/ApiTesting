package com.anakie.TestingAPI.controller;


import com.anakie.TestingAPI.model.URIGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apiTest/googleLens")
public class GoogleLensResult implements URIGenerator {

    @Value("${apiLayer.access_key}")
    private String apiKey;
    @Value("${searchAPI.apikey}")
    private String baseURI;


    @GetMapping("/")
    public ResponseEntity<GoogleLensResult> getLensResult(@RequestParam String url) throws URISyntaxException, IOException, InterruptedException {
        Map<String, String> parameters = new HashMap<>();


//        parameters.put("ql","za");  // by default, I'm focused on south african content
//        parameters.put("nfpr","1");  // set to 1, excludes autocorrected results
        parameters.put("safe","active"); // filter out adult content, enable safe browsing
        parameters.put("engine","google_lens"); // image engine
        parameters.put("api_key",apiKey);
        parameters.put("google_domain","google.co.za"); // focused on SA results
//        parameters.put("q",query);
        parameters.put("country","za");
        parameters.put("url",url); // image url
//        parameters.put("tbs","itp:face"); // we focus on faces.



        HttpClient client=HttpClient.newHttpClient();

        HttpRequest  request = HttpRequest.newBuilder().GET().uri(generateURI(parameters,baseURI)).build();
        HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());

        return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(),GoogleLensResult.class), HttpStatusCode.valueOf(response.statusCode()));
    }



}
