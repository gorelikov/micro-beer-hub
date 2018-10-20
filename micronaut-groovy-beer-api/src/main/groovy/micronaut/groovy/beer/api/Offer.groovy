package micronaut.groovy.beer.api

import groovy.transform.AutoClone
import groovy.transform.AutoCloneStyle
import groovy.transform.Canonical

@AutoClone(style = AutoCloneStyle.COPY_CONSTRUCTOR)
@Canonical
class Offer {
    String type
    Integer bottles
    Integer totalPrice
    String placeId
    Place place
}
