package io.bytestorm.core.impl.template;

import io.bytestorm.api.server.CloudServerTemplate;
import io.reactivex.rxjava3.annotations.Nullable;
import lombok.NonNull;

import java.util.List;

public class CloudServerTemplateImpl implements CloudServerTemplate {
    @Override
    public @NonNull String getName() {
        return "";
    }

    @Override
    public @Nullable String getGroup() {
        return "";
    }

    @Override
    public @NonNull String getBaseDirectory() {
        return "";
    }

    @Override
    public @NonNull List<String> getJvmArguments() {
        return List.of();
    }

    @Override
    public int getMinimumMemory() {
        return 0;
    }

    @Override
    public int getMaximumMemory() {
        return 0;
    }
}
