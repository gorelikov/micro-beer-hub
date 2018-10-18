package bar.tender.service;

import bar.tender.entity.Order;

public interface BarTenderService {
    void accumulateOrder(Order order);
}
