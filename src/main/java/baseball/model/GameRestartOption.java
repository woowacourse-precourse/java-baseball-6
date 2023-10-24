package baseball.model;

import java.util.stream.Stream;

public enum GameRestartOption {

    RESTART(1),
    END(2);

    private final int optionNumber;

    GameRestartOption(int optionNumber) {
        this.optionNumber = optionNumber;
    }

    public static GameRestartOption from(int optionNumber) {
        return Stream.of(values())
                .filter(gameRestartOption -> gameRestartOption.optionNumber == optionNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.RESTART_EXCEPTION_MESSAGE));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
