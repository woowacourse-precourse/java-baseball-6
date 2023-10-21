package baseball.domain;

import java.util.Objects;

public class Ball {
    private static final String INVALID_NUMBER_MESSAGE = "1에서 9사이의 숫자를 입력해주세요";
    public static final int LOWER_LIMIT = 1;
    public static final int UPPER_LIMIT = 9;

    private final int number;

    public Ball(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < LOWER_LIMIT || number > UPPER_LIMIT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ball ball)) {
            return false;
        }
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
