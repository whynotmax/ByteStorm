package io.bytestorm.api.messaging;

@FunctionalInterface
public interface MessageSubscriber<T extends Message> {
    void onMessage(T message);
}
