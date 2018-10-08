package com.example.spring.beer.hub.service;

import com.example.spring.beer.hub.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BarService {
    public String makeOrder(Order order) {
        log.debug("Order {} accepted", order);
        return UUID.randomUUID().toString();
    }
}
