package com.florian935.consumer1.consumer.impl;

import com.florian935.consumer1.consumer.Consumer;
import com.florian935.consumer1.domain.Order;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderConsumerImpl implements Consumer<Order> {

    String QUEUE_NAME = "florian935.broadcast.consumer1";

    @Override
    @RabbitListener(queues = QUEUE_NAME)
    public void consumer(Order order) {

        System.out.printf("#### Message received from queue : %s\n", order.toString());
    }
}
