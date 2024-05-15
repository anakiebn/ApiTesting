package com.anakie.TestingAPI;

import com.anakie.TestingAPI.model.googleModel.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class TestingApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(TestingApiApplication.class, args);

	}

}
