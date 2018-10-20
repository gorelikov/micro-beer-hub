package micronaut.groovy.beer.api

import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
class BarService {
    private final PlacesClient placesClient
    private final OrderProducer orderProducer
    private final CompanionRepository companionRepository

    BarService(PlacesClient placesClient, OrderProducer orderProducer,
               CompanionRepository companionRepository) {
        this.placesClient = placesClient
        this.orderProducer = orderProducer
        this.companionRepository = companionRepository
    }

    def makeOrder(Order order) {
        log.debug('Order {} accepted', order)
        orderProducer.sendOrder(order)
        companionRepository.save(order.name)
        return UUID.randomUUID().toString()
    }

    def loadBars(String placeId) {
        return [
                new Bar(place: placesClient.findPlace(placeId))
        ] as List
    }
}