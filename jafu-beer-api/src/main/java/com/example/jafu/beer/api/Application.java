package com.example.jafu.beer.api;

import com.example.jafu.beer.api.controller.BeerHandler;
import com.example.jafu.beer.api.service.BarService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonInitializer;
import org.springframework.boot.autoconfigure.jackson.JacksonJsonCodecInitializer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;

import static org.springframework.boot.jafu.Jafu.application;

public class Application {

    public static SpringApplication app = application(app -> {
        app.beans(beans -> {
            beans.bean(BarService.class);
            beans.bean(BeerHandler.class);
        });
        app.server(server -> server.router(router -> {
            BeerHandler beerHandler = app.ref(BeerHandler.class);
            router.POST("/beer",  RequestPredicates.contentType(MediaType.APPLICATION_JSON),  beerHandler::makeOrder);
        }));
    });

    public static void main (String[] args) {
        app.addInitializers(new JacksonInitializer(new JacksonProperties()));
        app.addInitializers(new JacksonJsonCodecInitializer(false));
        app.run(args);
    }
}
