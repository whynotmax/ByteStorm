package io.bytestorm.core.command;

import java.util.List;

public record CommandContext(String command, List<String> args) {
}
