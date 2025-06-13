package io.bytestorm.controller.config;

public class ControllerConfig {
    private int httpPort = 8080;
    private String jwtSecret = "default-secret";

    public int getHttpPort() {
        return httpPort;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    // Add JSON deserialization if necessary
}
