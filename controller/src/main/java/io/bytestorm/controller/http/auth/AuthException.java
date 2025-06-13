package io.bytestorm.controller.http.auth;

public class AuthException extends RuntimeException {
    public AuthException(String msg) {
        super(msg);
    }
}
