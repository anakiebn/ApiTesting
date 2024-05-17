package com.anakie.TestingAPI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class TestingApiApplication {

	final static String GENDER = "MALE";

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(TestingApiApplication.class, args);
	}
}
