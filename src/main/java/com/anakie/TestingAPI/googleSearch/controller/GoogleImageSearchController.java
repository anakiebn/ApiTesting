package com.anakie.TestingAPI.backend.googleSearch.controller;

import com.anakie.TestingAPI.backend.googleSearch.model.URIGenerator;
import com.anakie.TestingAPI.backend.googleSearch.model.googleModel.ImageResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
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
//        (site:linkedin.com OR site:twitter.com OR site:facebook.com OR site:youtube.com OR site:instagram.com OR site:tiktok.com OR site:snapchat.com OR site:pinterest.com OR site:reddit.com OR site:tumblr.com OR site:whatsapp.com OR site:wechat.com OR site:telegram.org OR site:skype.com OR site:discord.com OR site:google.com)
        String rawQuery = "+"+query+"-city -town -state -restaurant -hotel"; //-city -town -state -restaurant -hotel

        // URL-encode the query string
        String encodedQuery = URLEncoder.encode(rawQuery, StandardCharsets.UTF_8);

        parameters.put("ql","za");  // by default, I'm focused on south african content
//        parameters.put("nfpr","1");  // set to 1, excludes autocorrected results
        parameters.put("safe","active"); // filter out adult content, enable safe browsing
        parameters.put("engine","google_images"); // image engine
        parameters.put("api_key",apiKey);
        parameters.put("google_domain","google.co.za"); // focused on SA results
        parameters.put("q",encodedQuery);
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
