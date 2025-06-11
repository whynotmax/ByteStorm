package io.bytestorm.common.events;

public abstract class CloudEvent {
    private final long timestamp;

    public CloudEvent() {
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }
}
