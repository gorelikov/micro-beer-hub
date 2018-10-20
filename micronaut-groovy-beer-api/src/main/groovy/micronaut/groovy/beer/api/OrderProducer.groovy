package micronaut.groovy.beer.api

import io.micronaut.configuration.kafka.annotation.KafkaClient
import io.micronaut.configuration.kafka.annotation.Topic
import io.micronaut.messaging.annotation.Body

@KafkaClient
interface OrderProducer {
    @Topic("orders")
    void sendOrder(@Body Order order)
}
