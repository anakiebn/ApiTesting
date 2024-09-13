package com.anakie.TestingAPI.backend.googleSearch.controller;

import com.anakie.TestingAPI.backend.googleSearch.model.URIGenerator;
import com.anakie.TestingAPI.backend.googleSearch.model.youtubeModel.Result;
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

@RestController
@RequestMapping("/apiTest/youtubeTranscript")
@Slf4j
public class YoutubeTranscriptController implements URIGenerator {


    @Value("${searchAPI.apikey}")
    private String apiKey;
    @Value("${searchAPI.baseURI}")
    private String baseURI;


    @GetMapping("/{video_id}")
    public ResponseEntity<Result> getTranscript(@PathVariable String video_id) throws URISyntaxException, IOException, InterruptedException {

        HttpClient client=HttpClient.newHttpClient();
        Map<String, String> parameters=new HashMap<>();

        parameters.put("engine","youtube_transcripts"); // image engine
        parameters.put("api_key",apiKey);
        parameters.put("lang","en");
        parameters.put("video_id",video_id);


            HttpRequest request=HttpRequest.newBuilder()
                    .GET().uri(generateURI(parameters,baseURI)).build();
            HttpResponse<String> response=client.send(request,HttpResponse.BodyHandlers.ofString());
            log.info(response.body());
            return new ResponseEntity<>(new ObjectMapper().registerModule(new JavaTimeModule()).readValue(response.body(),Result.class),HttpStatusCode.valueOf(response.statusCode()));


    }


}
