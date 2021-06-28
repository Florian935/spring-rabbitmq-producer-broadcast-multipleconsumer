package com.florian935.producerbroadcast.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfig {

    public static final String QUEUE_NAME_CONSUMER1 = "florian935.broadcast.consumer1";
    public static final String QUEUE_NAME_CONSUMER2 = "florian935.broadcast.consumer2";
    public static final String EXCHANGE_NAME = "florian935.exchange.broadcast";
    public static final String ROUTING_KEY = "florian935.routingKey.broadcast";

    @Bean
    public Queue consumer1Queue() {

        return new Queue(QUEUE_NAME_CONSUMER1);
    }

    @Bean
    public Queue consumer2Queue() {

        return new Queue(QUEUE_NAME_CONSUMER2);
    }

    @Bean
    public TopicExchange exchange() {

        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Binding consumer1Binding(TopicExchange exchange) {

        return BindingBuilder
                .bind(consumer1Queue())
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public Binding consumer2Binding(TopicExchange exchange) {

        return BindingBuilder
                .bind(consumer2Queue())
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {

        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate customRabbitTemplate(ConnectionFactory connectionFactory) {

        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());

        return rabbitTemplate;
    }
}
