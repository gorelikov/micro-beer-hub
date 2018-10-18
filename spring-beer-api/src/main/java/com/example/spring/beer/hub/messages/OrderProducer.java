package com.example.spring.beer.hub.messages;

import com.example.spring.beer.hub.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {
    private final BeerChannels beerChannels;

    public void sendOrder(Order order) {
        beerChannels.output().send(MessageBuilder.withPayload(order).build());
    }
}
