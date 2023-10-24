package baseball.view.input;

import java.util.Arrays;

public enum MainCommand {
    START_NEW_GAME("1", true),
    END_GAME("2", false);

    private final String commandValue;
    private final boolean shouldStartNewGame;

    MainCommand(String commandValue, boolean shouldStartNewGame) {
        this.commandValue = commandValue;
        this.shouldStartNewGame = shouldStartNewGame;
    }

    public static boolean shouldStartNewGame(String commandValue) {
        return Arrays.stream(values())
                .filter(command -> command.commandEquals(commandValue))
                .findAny()
                .map(command -> command.shouldStartNewGame)
                .orElseThrow(() -> new IllegalArgumentException(commandValue + "는 올바르지 않은 값입니다."));
    }

    private boolean commandEquals(String commandValue) {
        return this.commandValue.equals(commandValue);
    }

}
