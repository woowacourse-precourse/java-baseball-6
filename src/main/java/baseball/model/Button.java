package baseball.model;

import java.util.Arrays;
import java.util.Optional;

public enum Button {

    GAME_START("1"),
    GAME_OVER("2");

    private final String name;

    Button(String name) {
        this.name = name;
    }

    public static Button findButton(String name) {
        Optional<Button> button = Arrays.stream(Button.values())
                .filter(b -> b.name.equals(name))
                .findFirst();
        if (button.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return button.get();
    }

    public boolean isGameOver() {
        return this == GAME_OVER;
    }
}
