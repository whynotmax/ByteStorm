package io.bytestorm.api.messaging;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ChannelRegistry {

    private final Map<String, MessageChannel<?>> channels = new ConcurrentHashMap<>();

    public <T extends Message> void registerChannel(MessageChannel<T> channel) {
        channels.put(channel.getName(), channel);
    }

    @SuppressWarnings("unchecked")
    public <T extends Message> Optional<MessageChannel<T>> getChannel(String name) {
        return Optional.ofNullable((MessageChannel<T>) channels.get(name));
    }

    public void unregisterChannel(String name) {
        channels.remove(name);
    }
}
