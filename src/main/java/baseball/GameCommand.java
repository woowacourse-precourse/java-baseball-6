package baseball;

import java.util.Arrays;

public enum GameCommand {
    CONTINUE("1", true),
    INNING_END("2", false),
    ;

    private final String gameCommand;
    private final boolean isContinue;

    GameCommand(String gameCommand, boolean isContinue) {
        this.gameCommand = gameCommand;
        this.isContinue = isContinue;
    }

    public static GameCommand from(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(value -> value.gameCommand.equals(command))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_GAME_COMMAND.getMessage()));
    }

    public boolean isContinue() {
        return isContinue;
    }
}
