package baseball.model.enums;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum RestartOrExitCommand {
    RESTART_GAME("1"),
    EXIT_GAME("2");

    private final String command;

    RestartOrExitCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static List<String> getCommands() {
        return Stream.of(RestartOrExitCommand.values())
                .map(restartOrExitCommand -> restartOrExitCommand.command)
                .collect(Collectors.toList());
    }
}
