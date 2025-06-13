package io.bytestorm.core.command;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {
    private final Map<String, CommandHandler> handlers = new HashMap<>();

    public void register(String name, CommandHandler handler) {
        handlers.put(name, handler);
    }

    public void execute(String command, CommandContext context) {
        CommandHandler handler = handlers.get(command);
        if (handler != null) handler.handle(context);
    }
}
