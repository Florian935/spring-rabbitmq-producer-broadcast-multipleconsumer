package com.florian935.producerbroadcast.controller;

import com.florian935.producerbroadcast.domain.Order;
import com.florian935.producerbroadcast.producer.Producer;
import com.florian935.producerbroadcast.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/orders")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;
    Producer<Order> orderProducer;

    @PostMapping(path = "", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    public Order saveBook(@RequestBody Order order) {

        final Order savedOrder = orderService.save(order);
        orderProducer.produce(order);

        return savedOrder;
    }
}
