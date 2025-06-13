package io.bytestorm.controller.http;

import io.bytestorm.controller.http.middleware.Middleware;
import io.bytestorm.controller.http.routes.RouteRegistry;

import java.util.ArrayList;
import java.util.List;

public class HttpServer {
    private final List<Middleware> middleware = new ArrayList<>();

    public void start() {
        System.out.println("[HTTP] Server starting on port 8080");
        new RouteRegistry().registerRoutes();
        middleware.forEach(Middleware::apply);
    }

    public void use(Middleware m) {
        middleware.add(m);
    }
}
