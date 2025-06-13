package io.bytestorm.core.impl.server;

import io.bytestorm.api.server.CloudServer;
import io.bytestorm.api.server.CloudServerGroup;
import io.bytestorm.api.server.CloudServerState;
import io.bytestorm.api.server.CloudServerTemplate;

import java.util.List;
import java.util.UUID;

public class CloudServerImpl implements CloudServer {
    @Override
    public UUID getUniqueId() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public CloudServerState getState() {
        return null;
    }

    @Override
    public List<CloudServerTemplate> getTemplates() {
        return List.of();
    }

    @Override
    public CloudServerGroup getGroup() {
        return null;
    }

    @Override
    public int getPort() {
        return 0;
    }

    @Override
    public long getUptime() {
        return 0;
    }

    @Override
    public void shutdown() {

    }
}
