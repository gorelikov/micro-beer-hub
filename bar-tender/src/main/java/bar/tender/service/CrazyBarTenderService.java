package bar.tender.service;

import bar.tender.client.PlacesClient;
import bar.tender.configuration.BarConfiguration;
import bar.tender.entity.Offer;
import bar.tender.entity.Order;
import bar.tender.entity.Place;
import bar.tender.messages.OfferProducer;
import io.micronaut.context.annotation.Value;
import lombok.RequiredArgsConstructor;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
@RequiredArgsConstructor
public class CrazyBarTenderService implements BarTenderService {
    @Inject
    private PlacesClient placesClient;

    @Value("${micronaut.application.name}")
    private String appName;

    @Inject
    private BarConfiguration barConfiguration;

    @Inject
    private OfferProducer offerProducer;

    private AtomicInteger totalAmount = new AtomicInteger();
    private ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();

    private String placeId;

    @PostConstruct
    public void init() {
        placeId = placesClient.savePlace(Place.builder()
                .averagePrice(barConfiguration.getPackPrice())
                .maxTableSize(barConfiguration.getTableSize())
                .name(appName)
                .build());
    }

    //DO NOT USE CONSTRUCTIONS LIKE THAT IN YOUR PRODUCTION CODE,PLEASE!
    // IT IS ONLY A DEMO %)
    @Override
    public void accumulateOrder(Order order) {
        int total = totalAmount.addAndGet(order.getMoney());
        map.compute(order.getName(), (name, old) -> old != null ? old + order.getMoney() : order.getMoney());
        if (total > barConfiguration.getPackPrice()) {
            Integer packs = total / barConfiguration.getPackPrice();
            offerProducer.sendOffer(
                    Offer.builder()
                            .placeId(placeId)
                            .bottles(packs * barConfiguration.getPackSize())
                            .totalPrice(packs * barConfiguration.getPackPrice())
                            .type(barConfiguration.getBeerType())
                            .build()
            );
        }
    }
}
