package baseball.model;

import baseball.util.ExceptionMessage;
import java.util.Arrays;
import java.util.function.Predicate;

public enum GameCommand {

    RETRY("1", true),
    QUIT("2", false);

    private final String gameCommand;
    private final boolean selectedRetry;

    GameCommand(String gameCommand, boolean selectedRetry) {
        this.gameCommand = gameCommand;
        this.selectedRetry = selectedRetry;
    }

    public static GameCommand from(String gameCommand) {
        return Arrays.stream(GameCommand.values())
                .filter(isSameCommand(gameCommand))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage()));
    }

    private static Predicate<GameCommand> isSameCommand(String gameCommand) {
        return value -> value.gameCommand.equals(gameCommand);
    }

    public boolean selectedRetry() {
        return selectedRetry;
    }
}
