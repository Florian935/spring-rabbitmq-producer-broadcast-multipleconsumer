package com.florian935.producerbroadcast.producer.impl;

import com.florian935.producerbroadcast.domain.Order;
import com.florian935.producerbroadcast.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static com.florian935.producerbroadcast.config.MessagingConfig.EXCHANGE_NAME;
import static com.florian935.producerbroadcast.config.MessagingConfig.ROUTING_KEY;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderProducerImpl implements Producer<Order> {

    RabbitTemplate customRabbitTemplate;

    @Override
    public void produce(Order order) {

        customRabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, order);
    }
}
