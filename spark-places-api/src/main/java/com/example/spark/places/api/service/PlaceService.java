package com.example.spark.places.api.service;


import com.example.spark.places.api.entity.Place;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class PlaceService {
    public static final String PLACES_COLLECTION = "places";
    public static final int MAX_RESULT = 100;
    private final MongoCollection placesCollection;

    public PlaceService(MongoDatabase database) {
        placesCollection = database.getCollection(PLACES_COLLECTION, Place.class);
    }

    public List<Place> findPlaces(Integer companySize, Integer minPrice, Integer maxPrice) {
        BasicDBObject criteria = new BasicDBObject();
        criteria.append("maxTableSize", new BasicDBObject("$gte",companySize));
        criteria.append("averagePrice", new BasicDBObject("$gte",minPrice).append("$lte",maxPrice));

        FindIterable<Place> findIterable = placesCollection.find(criteria, Place.class).limit(MAX_RESULT);
        return convertToList(findIterable);
    }

    private List<Place> convertToList(FindIterable<Place> findIterable) {
        List<Place> result = new ArrayList<>();
        for(Place place: findIterable) {
            result.add(place);
        }
        return result;
    }

    public String save(Place place) {
        log.debug("Place {} saved", place);
        placesCollection.insertOne(place);
        return place.getId();
    }

}
