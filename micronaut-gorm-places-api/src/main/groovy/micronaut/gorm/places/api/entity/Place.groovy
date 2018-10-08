package micronaut.gorm.places.api.entity

import grails.gorm.annotation.Entity
import groovy.transform.Canonical

import javax.persistence.Id

@Entity
@Canonical
class Place {
    @Id
    String id

    String name
    Integer averagePrice
    Integer maxTableSize

    static mapping = {
        compoundIndex averagePrice:1, maxTableSize:1
        name index:true, indexAttributes: [unique:true]
    }
}
