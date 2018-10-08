package com.example.spring.beer.hub.controller;

import com.example.spring.beer.hub.entity.Order;
import com.example.spring.beer.hub.service.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/beer")
@RequiredArgsConstructor
public class BeerController {
    private final BarService barService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody Order order) {
        return barService.makeOrder(order);
    }
}
