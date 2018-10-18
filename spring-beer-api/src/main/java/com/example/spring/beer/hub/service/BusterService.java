package com.example.spring.beer.hub.service;

import com.example.spring.beer.hub.entity.Buster;
import com.example.spring.beer.hub.entity.Offer;
import com.example.spring.beer.hub.repository.CompanionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BusterService {
    private final OfferService offerService;
    private final CompanionRepository companionRepository;
    private final Random rnd = new Random();

    public Buster create() {
        List<Offer> offers = offerService.loadOffers();
        if(offers.isEmpty()) {
            return null;
        }
        Set<String> companions = companionRepository.loadAll();
        Offer offer = offers.get(rnd.nextInt(offers.size()));
        return Buster.builder()
                .companions(companions)
                .offer(offer)
                .build();

    }
}
