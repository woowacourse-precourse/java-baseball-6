package baseball.game;

import java.util.Arrays;

public enum GameMenu {
    NEW_GAME("1"),
    EXIT("2");

    private final String code;

    GameMenu(String code) {
        this.code = code;
    }

    public static GameMenu of(String code) {
        return Arrays.stream(values())
                .filter(status -> status.code.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
