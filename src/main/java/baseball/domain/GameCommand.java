package baseball.domain;

import baseball.global.exception.CustomException;
import baseball.global.exception.ErrorMessage;
import java.util.Arrays;

public enum GameCommand {
    RESTART("1", true),
    QUIT("2", false);

    private final String command;
    private final boolean isRunning;

    GameCommand(String command, boolean isRunning) {
        this.command = command;
        this.isRunning = isRunning;
    }

    public static GameCommand from(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(element -> element.command.equals(command))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_NUMBER_ERROR));
    }

    public boolean isRunning() {
        return isRunning;
    }
}
