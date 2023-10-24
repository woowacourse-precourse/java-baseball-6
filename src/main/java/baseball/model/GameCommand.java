package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;

public enum GameCommand {

    RETRY("1", true),
    QUIT("2", false);

    private final String gameCommand;
    private final boolean selectedRetry;

    GameCommand(String gameCommand, boolean selectedRetry) {
        this.gameCommand = gameCommand;
        this.selectedRetry = selectedRetry;
    }

    public static boolean selectedRetry(String gameCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(value -> value.gameCommand.equals(gameCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage()))
                .selectedRetry;
    }
}
