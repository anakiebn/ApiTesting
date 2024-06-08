package com.anakie.TestingAPI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class TestingApiApplication {


	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(TestingApiApplication.class, args);
	}
}
