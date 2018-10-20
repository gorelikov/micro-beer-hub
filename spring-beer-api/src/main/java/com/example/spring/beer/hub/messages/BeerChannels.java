package com.example.spring.beer.hub.messages;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface BeerChannels {
    String ORDERS_OUTPUT = "orders";
    String BEER_INPUT = "beer";

    @Output(ORDERS_OUTPUT)
    MessageChannel output();

    @Input(BEER_INPUT)
    SubscribableChannel input();
}
