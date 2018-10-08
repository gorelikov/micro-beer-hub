package micronaut.gorm.places.api.service

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import micronaut.gorm.places.api.entity.Place

@Service
class PlacesService {

    @Transactional
    List<Place> findPlaces(Integer companySize, Integer minPrice, Integer maxPrice) {
            return Place.findAllByMaxTableSizeGreaterThanAndAveragePriceBetween(companySize, minPrice, maxPrice)
    }
}