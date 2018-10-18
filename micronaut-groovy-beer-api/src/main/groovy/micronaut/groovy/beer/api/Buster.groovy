package micronaut.groovy.beer.api

import groovy.transform.Canonical

@Canonical
class Buster {
    Offer offer
    Set<String> companions
}
