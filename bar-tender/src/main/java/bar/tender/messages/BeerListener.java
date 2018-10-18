package bar.tender.messages;

import bar.tender.entity.Order;
import bar.tender.service.BarTenderService;
import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;

import javax.inject.Inject;


@KafkaListener()
public class BeerListener {

    @Inject
    private BarTenderService barTenderService;

    @Topic("orders")
    public void receive(Order order) {
        barTenderService.accumulateOrder(order);
    }
}