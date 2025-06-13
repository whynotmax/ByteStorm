package io.bytestorm.core.impl.server;

import io.bytestorm.api.server.CloudServerGroup;
import io.bytestorm.api.server.CloudServerTemplate;
import lombok.NonNull;

import java.util.List;

public class CloudServerGroupImpl implements CloudServerGroup {
    @Override
    public @NonNull String getName() {
        return "";
    }

    @Override
    public int getMinimumServers() {
        return 0;
    }

    @Override
    public int getMaximumServers() {
        return 0;
    }

    @Override
    public List<CloudServerTemplate> getTemplates() {
        return List.of();
    }

    @Override
    public void addTemplate(@NonNull CloudServerTemplate template) {

    }

    @Override
    public void removeTemplate(@NonNull String templateName) {

    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isFallback() {
        return false;
    }
}
