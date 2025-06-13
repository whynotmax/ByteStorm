package io.bytestorm.core.command;

public interface CommandHandler {

    void handle(CommandContext context);

}
