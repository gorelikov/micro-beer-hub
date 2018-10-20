package micronaut.groovy.beer.api

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

import javax.validation.constraints.NotBlank

@Client(id = 'places-api', path = '/place')
interface PlacesClient {
    @Get(value = '{placeId}', produces = MediaType.APPLICATION_JSON)
    Place findPlace(@NotBlank String placeId)
}
