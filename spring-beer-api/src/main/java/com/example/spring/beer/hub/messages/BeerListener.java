package com.example.spring.beer.hub.messages;

import com.example.spring.beer.hub.entity.Offer;
import com.example.spring.beer.hub.repository.OffersRepository;
import com.example.spring.beer.hub.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerListener {
    private final OfferService offerService;

    @StreamListener(BeerChannels.BEER_INPUT)
    public void beerOffersProcessor(Offer offer) {
        offerService.saveOffer(offer);
    }
}
