package io.bytestorm.common.events.impl;

import io.bytestorm.common.events.Cancellable;
import io.bytestorm.common.events.CloudEvent;

public class PlayerConnectionRequestEvent extends CloudEvent implements Cancellable {



    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public void setCancelled(boolean cancelled) {

    }
}
