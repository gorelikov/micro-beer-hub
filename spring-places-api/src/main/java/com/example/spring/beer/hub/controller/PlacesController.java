package com.example.spring.beer.hub.controller;

import com.example.spring.beer.hub.entity.Place;
import com.example.spring.beer.hub.repository.PlacesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/place")
@RequiredArgsConstructor
public class PlacesController {
    private final PlacesRepository placesRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String savePlace(@RequestBody Place place) {
        return placesRepository.save(place).getId();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Place> findPlaces(
            @RequestParam("companySize") Integer companySize,
            @RequestParam("minPrice") Integer minPrice, @RequestParam("maxPrice") Integer maxPrice) {
        return placesRepository.findByMaxTableSizeGreaterThanAndAveragePriceBetween(companySize, minPrice, maxPrice);
    }

    @GetMapping(value = "{placeId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Place findPlace(@PathVariable("placeId")String placeId) {
        return placesRepository.findById(placeId).orElseGet(null);
    }
}
