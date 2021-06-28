package com.florian935.consumer2.consumer;

public interface Consumer<T> {

    void consume(T message);
}
