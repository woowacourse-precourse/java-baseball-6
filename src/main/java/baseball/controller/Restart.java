package baseball.controller;

import java.util.Arrays;

public enum Restart {
    TRUE(1),
    FALSE(2);

    private final int restart;

    Restart(int restart) {
        this.restart = restart;
    }

    public static Restart from(String restart) {
        return Arrays.stream(values())
                .filter(value -> value.restart == Integer.parseInt(restart))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isTrue() {
        return this == TRUE;
    }
}
