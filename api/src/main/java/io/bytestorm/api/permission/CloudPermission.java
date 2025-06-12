package io.bytestorm.api.permission;

import lombok.NonNull;

public record CloudPermission(String node, boolean granted) {

    public CloudPermission(String node) {
        this(node, true);
    }

    public CloudPermission(String node, boolean granted) {
        if (node == null || node.isEmpty()) {
            throw new IllegalArgumentException("Node cannot be null or empty");
        }
        this.node = node;
        this.granted = granted;
    }

    @Override
    public @NonNull String toString() {
        return "CloudPermission{" +
                "node='" + node + '\'' +
                ", granted=" + granted +
                '}';
    }
}
