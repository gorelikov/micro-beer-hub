package micronaut.groovy.beer.api


import groovy.transform.Canonical

@Canonical
class Place {
    String id
    String name
    Integer averagePrice
    Integer maxTableSize
}
