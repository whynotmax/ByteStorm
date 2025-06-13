package io.bytestorm.controller.http.auth;

import java.util.UUID;

public class TokenManager {
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}
