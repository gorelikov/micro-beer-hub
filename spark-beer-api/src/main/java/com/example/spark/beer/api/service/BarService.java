package com.example.spark.beer.api.service;


import com.example.spark.beer.api.entity.Order;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class BarService {
    public String makeOrder(Order order) {
        log.debug("Order {} accepted", order);
        return UUID.randomUUID().toString();
    }
}
