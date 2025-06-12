package io.bytestorm.api.server;

import java.util.List;
import java.util.UUID;

public interface CloudServer {

    UUID getUniqueId();

    String getName();

    CloudServerState getState();

    List<CloudServerTemplate> getTemplates();

    CloudServerGroup getGroup();

    int getPort();

    long getUptime();

    void shutdown();

}
