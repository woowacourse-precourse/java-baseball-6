package baseball.domain.ball;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum GameStatus {
    UNKNOWN("_"),
    REPLAY("1"),
    EXIT("2");

    private static final Map<String, GameStatus> enumMap =
            Arrays.stream(values())
                    .collect(Collectors.toMap(
                            gameStatus -> gameStatus.input,
                            gameStatus -> gameStatus
                    ));
    private final String input;

    GameStatus(final String input) {
        this.input = input;
    }

    public static GameStatus of(final String input) {
        return enumMap.getOrDefault(input, UNKNOWN);
    }
}
