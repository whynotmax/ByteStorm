package io.bytestorm.core.impl.messaging;

import io.bytestorm.api.messaging.*;
import jakarta.annotation.Nullable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.redisson.api.RedissonClient;

import java.util.HashMap;
import java.util.Map;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MessagingServiceImpl implements MessagingService {

    ChannelRegistry channelRegistry;

    String address;
    @Nullable
    String password;

    RedissonClient redisson;

    public MessagingServiceImpl(String address) {
        this(address, null);
    }

    public MessagingServiceImpl(String address, @Nullable String password) {
        this.channelRegistry = new ChannelRegistry();
        this.address = address;
        this.password = password;

        // Hier könnte eine Initialisierung des Redisson-Clients erfolgen,
        // z.B. durch Aufruf einer Methode, die eine RedissonClient-Instanz erstellt.
        redisson = null; // Placeholder, should be initialized properly
    }

    @Override
    public <T extends Message> MessageChannel<T> createChannel(String name, Class<T> type) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Channel name cannot be null or empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("Message type cannot be null");
        }

        MessageChannel<T> channel =  MessageChannelFactory.createChannel(name, type);
        channelRegistry.registerChannel(channel);
        return channel;
    }

    @Override
    public ChannelRegistry getRegistry() {
        return this.channelRegistry;
    }
}