package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;

public enum GameCommand {
    GAME_START("1"),
    GAME_EXIT("2");

    private final String command;

    private GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand decideGameCommand(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.WRONG_INPUT));
    }

}
