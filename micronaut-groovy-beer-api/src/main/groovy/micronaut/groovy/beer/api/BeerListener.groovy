package micronaut.groovy.beer.api

import io.micronaut.configuration.kafka.annotation.KafkaListener
import io.micronaut.configuration.kafka.annotation.OffsetReset
import io.micronaut.configuration.kafka.annotation.Topic

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
class BeerListener {
    private final OfferRepository offersRepository

    BeerListener(OfferRepository offersRepository) {
        this.offersRepository = offersRepository
    }

    @Topic("beer")
    void beerOffersProcessor(Offer offer) {
        offersRepository.saveOffer(offer)
    }
}
