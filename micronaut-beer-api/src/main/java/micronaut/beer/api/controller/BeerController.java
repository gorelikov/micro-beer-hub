package micronaut.beer.api.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.extern.slf4j.Slf4j;
import micronaut.beer.api.entity.Order;

import java.util.UUID;

@Slf4j
@Controller("/beer")
public class BeerController {

    @Post
    public HttpResponse index(@Body Order order) {
        log.debug("Order {} accepted", order);
        return HttpResponse.created(UUID.randomUUID().toString());
    }
}
