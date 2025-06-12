package io.bytestorm.api.player;

import java.time.Instant;

public record CloudPlayerSession(String ip, Instant connectedAt, String currentServer) {


}
