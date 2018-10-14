package micronaut.gorm.places.api.controller

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import micronaut.gorm.places.api.entity.Place
import micronaut.gorm.places.api.service.PlacesService

import javax.validation.constraints.NotBlank

@Controller('/place')
class PlacesController {
    private final PlacesService placesService

    PlacesController(PlacesService placesService) {
        this.placesService = placesService
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    List<Place> findPlaces(@QueryValue('companySize') Integer companySize,
                                         @QueryValue('minPrice') Integer minPrice, @QueryValue('maxPrice') Integer maxPrice) {
        List<Place> places = placesService.findPlaces(companySize, minPrice, maxPrice)
        return places

    }

    @Get(value = '{placeId}', produces = MediaType.APPLICATION_JSON)
    Place findPlace(@NotBlank String placeId) {
        Place place = placesService.findPlace(placeId)
        return place

    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    HttpResponse<String> savePlace(@Body Place place) {
        return HttpResponse.created(placesService.save(place))
    }
}