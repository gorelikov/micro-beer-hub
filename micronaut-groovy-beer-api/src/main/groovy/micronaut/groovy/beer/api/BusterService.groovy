package micronaut.groovy.beer.api

import javax.inject.Singleton

@Singleton
class BusterService {
    private final OfferService offerService
    private final CompanionRepository companionRepository
    private final Random rnd = new Random()

    BusterService(OfferService offerService, CompanionRepository companionRepository) {
        this.offerService = offerService
        this.companionRepository = companionRepository
    }

    Buster create() {
        List<Offer> offers = offerService.loadOffers()
        if(offers.isEmpty()) {
            return null
        }
        Set<String> companions = companionRepository.loadAll()
        Offer offer = offers.get(rnd.nextInt(offers.size()))
        return new Buster(
                companions: companions,
                offer: offer
        )
    }
}
