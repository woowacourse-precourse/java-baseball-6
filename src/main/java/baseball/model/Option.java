package baseball.model;

import java.util.stream.Stream;

public enum Option {

    GAME_START(1),
    GAME_OVER(2);

    private final int number;

    Option(int number) {
        this.number = number;
    }

    public static Option getOptionByNumber(int number) {
        return Stream.of(Option.values())
                .filter(o -> o.equals(number))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean equals(int number) {
        return this.number == number;
    }

    public boolean isGameOver() {
        return this == GAME_OVER;
    }
}
