package io.bytestorm.common.events;

public interface Cancellable {
    boolean isCancelled();
    void setCancelled(boolean cancelled);
}
