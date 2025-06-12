package io.bytestorm.api.messaging;

import org.redisson.api.RedissonClient;

public interface MessagingService {

    RedissonClient getRedisson(); // Zugriff auf Redisson

    <T extends Message> MessageChannel<T> createChannel(String name, Class<T> type);

    ChannelRegistry getRegistry();
}
