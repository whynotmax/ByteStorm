package io.bytestorm.controller.http.routes;

public class RouteRegistry {
    public void registerRoutes() {
        new ServerRoute().register();
        new UserRoute().register();
    }
}
