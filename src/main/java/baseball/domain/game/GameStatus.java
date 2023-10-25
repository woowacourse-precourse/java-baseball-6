package baseball.domain.game;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameStatus {
    UNKNOWN("_"),
    REPLAY("1"),
    EXIT("2");

    private static final Map<String, GameStatus> enumMap =
            Stream.of(values())
                    .collect(Collectors.toMap(e -> e.input, e -> e));
    private final String input;

    GameStatus(final String input) {
        this.input = input;
    }

    public static GameStatus of(final String input) {
        return enumMap.getOrDefault(input, UNKNOWN);
    }
}
