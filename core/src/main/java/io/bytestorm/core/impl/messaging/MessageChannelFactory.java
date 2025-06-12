package io.bytestorm.core.impl.messaging;

import io.bytestorm.api.messaging.Message;
import io.bytestorm.api.messaging.MessageChannel;
import io.bytestorm.api.messaging.MessagePublisher;
import io.bytestorm.api.messaging.MessageSubscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageChannelFactory {

    public static <T extends Message> MessageChannel<T> createChannel(String name, Class<T> type) {
        return new MessageChannel<T>() {

            List<MessageSubscriber<T>> subscribers = new ArrayList<>();
            MessagePublisher<T> publisher;

            @Override
            public String getName() {
                return name + "_" + type.getSimpleName();
            }

            @Override
            public void subscribe(MessageSubscriber<T> subscriber) {
                subscribers.add(subscriber);
            }

            @Override
            public void unsubscribe(MessageSubscriber<T> subscriber) {
                subscribers.remove(subscriber);
            }

            @Override
            public MessagePublisher<T> publisher() {
                if (publisher == null) {
                    publisher = message -> {
                        for (MessageSubscriber<T> subscriber : subscribers) {
                            subscriber.onMessage(message);
                        }
                    };
                }
                return publisher;
            }
        };
    }
}
