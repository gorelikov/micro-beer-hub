package com.example.spring.beer.hub.service;

import com.example.spring.beer.hub.client.PlacesClient;
import com.example.spring.beer.hub.entity.Bar;
import com.example.spring.beer.hub.entity.Order;
import com.example.spring.beer.hub.entity.Place;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BarService {
    private final PlacesClient placesClient;

    public String makeOrder(Order order) {
        log.debug("Order {} accepted", order);
        return UUID.randomUUID().toString();
    }

    public List<Bar> loadBars(String placeId) {
        Place place = placesClient.findPlace(placeId);
        return Arrays.asList(Bar.builder().place(place).build());
    }
}
