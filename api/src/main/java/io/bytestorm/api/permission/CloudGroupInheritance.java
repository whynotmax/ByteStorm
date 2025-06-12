package io.bytestorm.api.permission;

import lombok.NonNull;

public record CloudGroupInheritance(String cloudGroupName, int priority) {

    public CloudGroupInheritance(String cloudGroupName) {
        this(cloudGroupName, 0);
    }

    public CloudGroupInheritance {
        if (cloudGroupName == null || cloudGroupName.isEmpty()) {
            throw new IllegalArgumentException("Cloud group name cannot be null or empty");
        }
        if (priority < 0) {
            throw new IllegalArgumentException("Priority must be non-negative");
        }
        if (priority > 100) {
            throw new IllegalArgumentException("Priority must not exceed 100");
        }
    }

    @Override
    public @NonNull String toString() {
        return "CloudGroupInheritance{" +
                "cloudGroupName='" + cloudGroupName + '\'' +
                ", priority=" + priority +
                '}';
    }
}
