package micronaut.groovy.beer.api

import com.fasterxml.jackson.databind.ObjectMapper
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.sync.RedisCommands

import javax.inject.Singleton
import java.util.stream.Collectors

@Singleton
class OfferRepository {
    private final ObjectMapper objectMapper
    private final StatefulRedisConnection<String, String> connection
    private final RedisCommands<String, Offer> command
    private static final String KEY = "OFFERS"

    OfferRepository(StatefulRedisConnection<String, Offer> connection, ObjectMapper objectMapper) {
        this.connection = connection
        this.command = connection.sync()
        this.objectMapper = objectMapper
    }

    Map<String, Offer> findAllOffers() {
        command.hgetall(KEY).entrySet().stream()
        .collect(Collectors.toMap({it.key}, {objectMapper.readValue(it.value, Offer)}))
    }

    void saveOffer(Offer offer) {
        String val = objectMapper.writeValueAsString(offer)
        command.hset(KEY, offer.getPlaceId(), val)
    }
}
