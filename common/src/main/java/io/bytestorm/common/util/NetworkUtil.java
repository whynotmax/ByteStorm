package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.net.InetAddress;
import java.net.UnknownHostException;

@UtilityClass
public class NetworkUtil {

    public String getLocalIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "127.0.0.1";
        }
    }

    public boolean isPortAvailable(int port) {
        try (var socket = new java.net.ServerSocket(port)) {
            socket.setReuseAddress(true);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
