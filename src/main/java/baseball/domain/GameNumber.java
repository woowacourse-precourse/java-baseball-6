package baseball.domain;

import java.util.stream.Stream;

public enum GameNumber {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    private static final String RANGE_EXCEPTION_MESSAGE =
            String.format("Error : 각 자리수는 %d ~ %d 사이의 숫자여야 합니다.", MIN_NUMBER, MAX_NUMBER);

    private final int number;

    GameNumber(int number) {
        this.number = number;
    }

    public static GameNumber from(int number) {
        return Stream.of(GameNumber.values())
                .filter(gameNumber -> gameNumber.number == number)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE));
    }
}
