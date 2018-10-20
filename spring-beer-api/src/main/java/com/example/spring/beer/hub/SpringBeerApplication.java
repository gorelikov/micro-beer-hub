package com.example.spring.beer.hub;

import com.example.spring.beer.hub.messages.BeerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableBinding(BeerChannels.class)
public class SpringBeerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeerApplication.class, args);
	}
}
