package com.example.spring.beer.hub.controller;

import com.example.spring.beer.hub.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/beer")
public class BeerController {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody Order order) {
        log.debug("Order {} accepted", order);
        return UUID.randomUUID().toString();
    }
}
