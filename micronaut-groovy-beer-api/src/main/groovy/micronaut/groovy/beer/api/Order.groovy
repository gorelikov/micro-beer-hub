package micronaut.groovy.beer.api

import groovy.transform.Canonical

@Canonical
class Order {
    String name
    Integer money
}
