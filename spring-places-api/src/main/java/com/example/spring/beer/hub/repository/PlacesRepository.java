package com.example.spring.beer.hub.repository;

import com.example.spring.beer.hub.entity.Place;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlacesRepository extends MongoRepository<Place, String> {
    List<Place> findByMaxTableSizeGreaterThanAndAveragePriceBetween(Integer tableSize,
                                                                     Integer minPrice, Integer maxPrice);
}
