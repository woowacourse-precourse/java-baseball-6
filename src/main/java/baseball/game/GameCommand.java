package baseball.game;

import java.util.Arrays;

import static baseball.common.Constants.FIND_COMMAND_ERROR;

public enum GameCommand {
    RETRY(1),
    QUIT(2);

    private final Integer command;

    GameCommand(Integer command) {
        this.command = command;
    }

    public static GameCommand findByCommand(Integer input) {
        return Arrays.stream(GameCommand.values())
                .filter(gameCommand -> gameCommand.command == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(FIND_COMMAND_ERROR));
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }
}
