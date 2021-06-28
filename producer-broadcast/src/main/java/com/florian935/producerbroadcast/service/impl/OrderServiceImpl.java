package com.florian935.producerbroadcast.service.impl;

import com.florian935.producerbroadcast.domain.Order;
import com.florian935.producerbroadcast.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order save(Order order) {

        order.setUuid(UUID.randomUUID().toString());

        return order;
    }
}
