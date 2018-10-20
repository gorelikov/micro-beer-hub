package com.example.spring.beer.hub.service;

import com.example.spring.beer.hub.client.PlacesClient;
import com.example.spring.beer.hub.entity.Offer;
import com.example.spring.beer.hub.repository.OffersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final PlacesClient placesClient;
    private final OffersRepository offersRepository;

    public List<Offer> loadOffers() {
        return offersRepository.findAllOffers()
                .entrySet().stream()
                .parallel()
                .map(this::fillPlace)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(Offer::getTotalPrice).reversed())
                .collect(Collectors.toList());
    }

    private Offer fillPlace(Map.Entry<String, Offer> entry) {
        try {
            return entry.getValue().withPlace(placesClient.findPlace(entry.getKey()));
        } catch (Exception e) {
            return null;
        }
    }

    public void saveOffer(Offer offer) {
        offersRepository.saveOffer(offer);
    }
}
