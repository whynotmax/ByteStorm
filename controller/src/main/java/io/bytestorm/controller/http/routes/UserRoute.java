package io.bytestorm.controller.http.routes;

public class UserRoute implements Route {
    @Override
    public void register() {
        System.out.println("[Route] /users endpoint registered.");
    }
}
