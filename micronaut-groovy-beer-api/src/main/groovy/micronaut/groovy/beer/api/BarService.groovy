package micronaut.groovy.beer.api

import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
class BarService {

    private final PlacesClient placesClient

    BarService(PlacesClient placesClient) {
        this.placesClient = placesClient
    }

    def makeOrder(Order order) {
        log.debug('Order {} accepted', order)
        return UUID.randomUUID().toString()
    }

    def loadBars(String placeId) {
        return [
                new Bar(place: placesClient.findPlace(placeId))
        ] as List
    }
}