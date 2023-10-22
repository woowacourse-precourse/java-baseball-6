package baseball.util;

import java.util.Arrays;

public enum GameCommand {
    GAME_RESTART("1"), GAME_OVER("2"), UNKNOWN_COMMAND("ERROR");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand findByInputCommand(String inputCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.getCommand().equals(inputCommand))
                .findAny()
                .orElse(UNKNOWN_COMMAND);
    }

    public String getCommand() {
        return command;
    }
}
