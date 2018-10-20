package micronaut.beer.api.service;

import lombok.extern.slf4j.Slf4j;
import micronaut.beer.api.entity.Order;

import javax.inject.Singleton;
import java.util.UUID;

@Slf4j
@Singleton
public class BarService {
    public String makeOrder(Order order) {
        log.debug("Order {} accepted", order);
        return UUID.randomUUID().toString();
    }
}
