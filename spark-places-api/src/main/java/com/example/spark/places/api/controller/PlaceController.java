package com.example.spark.places.api.controller;

import com.example.spark.places.api.entity.Place;
import com.example.spark.places.api.service.PlaceService;
import com.google.gson.Gson;

import static spark.Spark.get;
import static spark.Spark.post;

public class PlaceController {
    private final PlaceService placeService;
    private final Gson gson;

    public PlaceController(PlaceService placeService, Gson gson) {
        this.placeService = placeService;
        this.gson = gson;
        initEndpoints();
    }

    private void initEndpoints() {
        post("/place", (req, res) -> {
            Place place = gson.fromJson(req.body(), Place.class);
            return placeService.save(place);
        });

        get("/place", (req, res) -> {
            Integer companySize = req.queryMap("companySize").integerValue();
            Integer minPrice = req.queryMap("minPrice").integerValue();
            Integer maxPrice = req.queryMap("maxPrice").integerValue();
            return placeService.findPlaces(companySize, minPrice, maxPrice);
        });

    }
}
