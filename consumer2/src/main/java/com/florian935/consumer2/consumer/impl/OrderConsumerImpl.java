package com.florian935.consumer2.consumer.impl;

import com.florian935.consumer2.consumer.Consumer;
import com.florian935.consumer2.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderConsumerImpl implements Consumer<Order> {

    private static final String QUEUE_NAME = "florian935.broadcast.consumer2";

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void consume(Order order) {

        System.out.printf("#### Message received from queue : %s\n", order.toString());
    }
}
