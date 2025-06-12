package io.bytestorm.api.messaging;

public interface MessageChannel<T extends Message> {
    String getName();
    void subscribe(MessageSubscriber<T> subscriber);
    void unsubscribe(MessageSubscriber<T> subscriber);
    MessagePublisher<T> publisher();
}
