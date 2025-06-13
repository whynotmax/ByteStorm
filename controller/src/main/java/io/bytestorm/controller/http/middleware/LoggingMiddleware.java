package io.bytestorm.controller.http.middleware;

public class LoggingMiddleware implements Middleware {
    @Override
    public void apply() {
        System.out.println("[Middleware] Logging enabled");
    }
}
