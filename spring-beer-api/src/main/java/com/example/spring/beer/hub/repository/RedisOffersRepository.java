package com.example.spring.beer.hub.repository;

import com.example.spring.beer.hub.entity.Offer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RedisOffersRepository implements OffersRepository {
    private static final String KEY = "OFFERS";

    private final RedisTemplate<String, Offer> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, Offer> findAllOffers() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void saveOffer(Offer offer) {
        hashOperations.put(KEY, offer.getPlaceId(), offer);
    }
}
