package com.example.spring.beer.hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SpringBeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeerApplication.class, args);
	}
}
