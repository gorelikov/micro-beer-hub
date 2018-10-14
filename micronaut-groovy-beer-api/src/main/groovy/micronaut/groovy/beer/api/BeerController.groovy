package micronaut.groovy.beer.api

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.QueryValue

@Controller("/beer")
class BeerController {

    private final BarService barService

    BeerController(BarService barService) {
        this.barService = barService
    }

    @Post
    HttpResponse makeOrder(@Body Order order) {
        return HttpResponse.created(barService.makeOrder(order))
    }

    @Get
    List<Bar> loadBars(@QueryValue('placeId') String placeId) {
        return barService.loadBars(placeId)
    }
}