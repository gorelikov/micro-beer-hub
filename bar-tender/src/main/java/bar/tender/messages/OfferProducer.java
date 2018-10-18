package bar.tender.messages;

import bar.tender.entity.Offer;
import io.micronaut.configuration.kafka.annotation.KafkaClient;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.Body;

@KafkaClient
public interface OfferProducer {

    @Topic("beer")
    void sendOffer(@Body Offer offer);
}
