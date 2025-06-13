package io.bytestorm.controller.http.auth;

public class AuthService {
    public boolean authenticate(String token) {
        return "secure-token".equals(token); // Replace with JWT logic
    }
}
