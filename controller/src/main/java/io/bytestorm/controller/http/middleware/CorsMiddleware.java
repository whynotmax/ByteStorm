package io.bytestorm.controller.http.middleware;

public class CorsMiddleware implements Middleware {
    @Override
    public void apply() {
        System.out.println("[Middleware] CORS enabled");
    }
}
