package micronaut.beer.api.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import micronaut.beer.api.entity.Order;
import micronaut.beer.api.service.BarService;

import javax.inject.Inject;

@Slf4j
@Controller("/beer")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class BeerController {
    private final BarService barService;

    @Post
    public HttpResponse index(@Body Order order) {
        return HttpResponse.created(barService.makeOrder(order));
    }
}
