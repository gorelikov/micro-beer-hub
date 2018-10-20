package com.example.spring.beer.hub.controller;

import com.example.spring.beer.hub.entity.Bar;
import com.example.spring.beer.hub.entity.Buster;
import com.example.spring.beer.hub.entity.Offer;
import com.example.spring.beer.hub.entity.Order;
import com.example.spring.beer.hub.service.BarService;
import com.example.spring.beer.hub.service.BusterService;
import com.example.spring.beer.hub.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/beer")
@RequiredArgsConstructor
public class BeerController {
    private final BarService barService;
    private final OfferService offerService;
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody Order order) {
        return barService.makeOrder(order);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bar> getBars(@QueryParam("placeId")String placeId) {
        return barService.loadBars(placeId);
    }

    @GetMapping("offers")
    public List<Offer> loadOffers() {
        return offerService.loadOffers();
    }

}
