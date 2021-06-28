package com.florian935.producerbroadcast.producer;

public interface Producer<T> {

    void produce(T message);
}
