package baseball;

import java.util.Arrays;

public enum GameMenu {
    REPLAY("1"), EXIT("2");

    private final String value;

    GameMenu(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public static GameMenu from(String value) {
        return Arrays.stream(values())
                .filter(menu -> menu.value.equals(value))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
