package baseball.domain.utils;

import java.util.Arrays;

public enum GameOption {
    PLAY_GAME(1),
    QUIT_GAME(2);
    private final int option;

    GameOption(int option) {
        this.option = option;
    }

    public int getOption() {
        return option;
    }

    public static GameOption valueOfOption(int input) {
        return Arrays.stream(GameOption.values())
                .filter(value -> value.getOption() == input)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
