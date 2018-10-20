package com.example.spring.beer.hub.client;

import com.example.spring.beer.hub.entity.Place;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("places-api")
@RequestMapping("/place")
public interface PlacesClient {

    @GetMapping(value = "{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    Place findPlace(@PathVariable("placeId")String placeId);
}
