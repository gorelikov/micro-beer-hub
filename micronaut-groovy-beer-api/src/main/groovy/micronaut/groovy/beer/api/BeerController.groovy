package micronaut.groovy.beer.api

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post

@Controller("/beer")
class BeerController {

    private final BarService barService

    BeerController(BarService barService) {
        this.barService = barService
    }

    @Post
    HttpResponse index(@Body Order order) {
        return HttpResponse.created(barService.makeOrder(order))
    }
}