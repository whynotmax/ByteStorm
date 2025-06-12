package io.bytestorm.api.messaging;

public interface MessagePublisher<T extends Message> {
    void publish(T message);
}
