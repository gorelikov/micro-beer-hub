package com.example.jafu.beer.api.controller;

import com.example.jafu.beer.api.entity.Order;
import com.example.jafu.beer.api.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class BeerHandler {
    private final BarService barService;
    public Mono<ServerResponse> makeOrder(ServerRequest request) {
        return ServerResponse.status(HttpStatus.CREATED)
                .body(
                        request.bodyToMono(Order.class)
                                .map(barService::makeOrder),
                        String.class
                );
    }
}
