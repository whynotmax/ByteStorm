package io.bytestorm.controller.http.routes;

public class ServerRoute implements Route {
    @Override
    public void register() {
        System.out.println("[Route] /servers endpoint registered.");
    }
}
