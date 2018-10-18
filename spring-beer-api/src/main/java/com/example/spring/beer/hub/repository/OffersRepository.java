package com.example.spring.beer.hub.repository;

import com.example.spring.beer.hub.entity.Offer;

import java.util.Map;

public interface OffersRepository {
    Map<String, Offer> findAllOffers();
    void saveOffer(Offer offer);
}
