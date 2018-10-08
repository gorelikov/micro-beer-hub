package micronaut.gorm.places.api.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import micronaut.gorm.places.api.entity.Place
import micronaut.gorm.places.api.service.PlacesService

@Controller("/place")
class PlacesController {
    private final PlacesService placesService

    PlacesController(PlacesService placesService) {
        this.placesService = placesService
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    HttpResponse<List<Place>> findPlaces(@QueryValue("companySize") Integer companySize,
                                         @QueryValue("minPrice") Integer minPrice, @QueryValue("maxPrice") Integer maxPrice) {
        List<Place> places = placesService.findPlaces(companySize, minPrice, maxPrice)
        return HttpResponse.ok(places)

    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    HttpResponse<String> savePlace(@Body Place place) {
        def savedPlace = place.save(flush: true)
        return HttpResponse.created(savedPlace.id)
    }
}