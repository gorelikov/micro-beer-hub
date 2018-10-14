package micronaut.gorm.places.api.entity


import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer
import grails.gorm.annotation.Entity
import groovy.transform.Canonical
import org.bson.types.ObjectId

@Entity
@Canonical
class Place {
    @JsonSerialize(using = ToStringSerializer)
    ObjectId id

    String name
    Integer averagePrice
    Integer maxTableSize

    static mapping = {
        collection 'places'
        compoundIndex averagePrice:1, maxTableSize:1
        name index:true, indexAttributes: [unique:true]
    }
}
