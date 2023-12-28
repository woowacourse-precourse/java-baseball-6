package baseball.model;

import java.util.Arrays;

public enum Button {

    GAME_START("1"),
    GAME_OVER("2");

    private final String name;

    Button(String name) {
        this.name = name;
    }

    public static Button findByName(String name) {
        return Arrays.stream(Button.values())
                .filter(b -> b.name.equals(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
