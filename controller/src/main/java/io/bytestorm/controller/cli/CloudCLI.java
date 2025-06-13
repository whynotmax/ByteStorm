package io.bytestorm.controller.cli;

import io.bytestorm.core.command.CommandContext;

import java.util.Arrays;

public class CloudCLI {
    private final CommandRegistry registry;

    public CloudCLI() {
        this.registry = new CommandRegistry();
        registry.registerDefaults();
    }

    public void handleInput(String input) {
        CommandContext context = new CommandContext(input, Arrays.stream(input.split(" ")).skip(1).toList());
        registry.execute(context);
    }
}
