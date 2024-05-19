package com.anakie.TestingAPI.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;


public interface URIGenerator {

  default URI generateURI(Map<String, String> parameters,String baseURI) throws URISyntaxException {

        StringBuilder generatedURI = new StringBuilder(baseURI);

        int count = 0;
        for (String name : parameters.keySet()) {
            String value = parameters.get(name);

            count++;

            generatedURI.append(name).append("=").append(value);
            if (count < parameters.size()) {
                generatedURI.append("&");
            }

        }

        System.out.printf("URI Generated; %s",generatedURI);
        return new URI(generatedURI.toString());
    }
}
