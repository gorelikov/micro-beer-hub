package micronaut.groovy.beer.api

import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
class BarService {
    
    def makeOrder(Order order) {
        log.debug('Order {} accepted', order)
        return UUID.randomUUID().toString()
    }
}