package io.bytestorm.controller.cli;

import io.bytestorm.controller.cli.commands.*;
import io.bytestorm.core.command.CommandContext;
import io.bytestorm.core.command.CommandHandler;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, CommandHandler> commands = new HashMap<>();

    public void registerDefaults() {
        register("start", new StartCommand());
        register("stop", new StopCommand());
        register("help", new HelpCommand());
    }

    public void register(String name, CommandHandler command) {
        commands.put(name, command);
    }

    public void execute(CommandContext context) {
        CommandHandler command = commands.get(context.command());
        if (command != null) command.handle(context);
        else System.out.println("Unknown command. Type 'help'.");
    }
}
