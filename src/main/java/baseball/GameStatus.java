package baseball;

import java.util.Arrays;
import java.util.Optional;

public enum GameStatus {
    CONTINUE("1"),
    END("2")
    ;

    private final String activateNumber;

    GameStatus(String activateNumber) {
        this.activateNumber = activateNumber;
    }

    public static Optional<GameStatus> getBy(String activateNumber) {
        return Arrays.stream(values())
                .filter(gameStatus -> gameStatus.activateNumber.equals(activateNumber))
                .findAny();
    }
}
