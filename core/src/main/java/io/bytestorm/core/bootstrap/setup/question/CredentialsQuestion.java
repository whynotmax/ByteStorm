package io.bytestorm.core.bootstrap.setup.question;

public class CredentialsQuestion implements SetupQuestion {

    String redissonUrl;
    String password; //optional

    String mongoUrl;
    String mongoDatabase;

    @Override
    public void run() {
        // This method should implement the logic to ask the user for credentials
        // For example, using a console input or a GUI dialog

    }

    @Override
    public void whenDone(Runnable callback) {

    }
}
