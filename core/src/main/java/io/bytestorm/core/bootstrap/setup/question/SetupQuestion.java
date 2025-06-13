package io.bytestorm.core.bootstrap.setup.question;

public interface SetupQuestion {

    void run();

    void whenDone(Runnable callback); //e.g., to start the next question

}
