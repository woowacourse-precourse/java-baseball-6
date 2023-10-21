package baseball.domain;

import static baseball.domain.ExceptionMessage.RESTART_EXCEPTION_MESSAGE;

import java.util.stream.Stream;

public enum GameRestartStatus {

    RESTART(1),
    END(2);

    private final int commandNumber;

    GameRestartStatus(int commandNumber) {
        this.commandNumber = commandNumber;
    }

    public static GameRestartStatus from(int commandNumber) {
        return Stream.of(values())
                .filter(gameRestartStatus -> gameRestartStatus.commandNumber == commandNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RESTART_EXCEPTION_MESSAGE));
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
