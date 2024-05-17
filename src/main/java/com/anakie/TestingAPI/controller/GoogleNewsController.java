package com.anakie.TestingAPI.controller;

import com.anakie.TestingAPI.model.URIGenerator;
import com.anakie.TestingAPI.model.googleModel.NewsResults;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/apiTest/googleNews")
public class GoogleNewsController implements URIGenerator {

    @Value("${searchAPI.apikey}")
    private String apiKey;
    @Value("${searchAPI.baseURI}")
    private String baseURI;

    @GetMapping("/")
    public ResponseEntity<NewsResults> getNews() throws URISyntaxException, IOException, InterruptedException {
        DateTimeFormatter format=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Map<String, String> parameters = new HashMap<>();
        parameters.put("api_key",apiKey);
        parameters.put("q","South+African+news");
        parameters.put("google_domain","google.co.za"); // focuses on south african content
        parameters.put("engine","google_news");
        parameters.put("as_dt", LocalDate.now().toString());
        parameters.put("inurl","south+africa"); //
        parameters.put("cr","za"); // SA news
        parameters.put("safe","active"); // filter out adult content
        parameters.put("time_period_min",LocalDate.now().minusMonths(1).format(format));
        parameters.put("time_period_max",LocalDate.now().format(format));

            HttpClient client= HttpClient.newHttpClient();
            HttpRequest request= HttpRequest.newBuilder().GET().uri(generateURI(parameters,baseURI)).build();

            HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
            log.info(response.body());
            return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(),NewsResults.class), HttpStatusCode.valueOf(response.statusCode()));



    }




}
