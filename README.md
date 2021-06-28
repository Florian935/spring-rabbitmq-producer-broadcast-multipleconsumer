# Demo of Spring Boot with RabbitMQ broadcast

## Run RabbitMQ with Docker

If you have docker compose, you can run `docker-compose up` and navigate to `http://localhost:15672` to see the web GUI RabbitMQ management console.

## Description

This project is a demo of how to broadcast message thanks to a producer contained in the `producer-broadcast package` and consume message from a RabbitMQ Broker with the `consumer1 package` and `consumer2 package`.