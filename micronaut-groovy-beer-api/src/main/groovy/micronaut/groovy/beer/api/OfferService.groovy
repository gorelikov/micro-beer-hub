package micronaut.groovy.beer.api

import javax.inject.Singleton
import java.util.stream.Collectors

@Singleton
class OfferService {
    private final OfferRepository offerRepository
    private final PlacesClient placesClient

    OfferService(OfferRepository offerRepository, PlacesClient placesClient) {
        this.offerRepository = offerRepository
        this.placesClient = placesClient
    }

    List<Offer> loadOffers() {
        offerRepository.findAllOffers().entrySet()
                .parallelStream()
                .map { fillByPlace(it.key, it.value) }
                .filter { it != null }
                .collect(Collectors.toList())
                .toSorted { a, b -> (b.getTotalPrice() <=> a.getTotalPrice()) }
    }

    private Offer fillByPlace(String placeId, Offer offer) {
        try {
            def clone = offer.clone()
            clone.place = placesClient.findPlace(placeId)
            return clone
        } catch (e) {
            return null
        }
    }

    void saveOffer(Offer offer) {
        offerRepository.saveOffer(offerRepository)
    }
}
