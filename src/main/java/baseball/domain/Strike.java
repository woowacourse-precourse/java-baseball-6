package baseball.domain;

import java.util.Objects;

public class Strike {
    private static final int ZERO_COUNT = 0;
    private static final int FULL_COUNT = 3;
    private static final String NO_STRIKE_MESSAGE = "";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String STRIKE_RANGE_EXCEPTION_MESSAGE = "스트라이크의 유효 범위는 0~3 입니다.";
    private final int strike;

    public Strike(int strike) {
        validateStrikeRange(strike);
        this.strike = strike;
    }

    private static void validateStrikeRange(int strike) {
        if (strike < ZERO_COUNT || FULL_COUNT < strike) {
            throw new IllegalArgumentException(STRIKE_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public boolean isEmpty() {
        return this.strike == ZERO_COUNT;
    }

    public boolean isFullCount() {
        return this.strike == FULL_COUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Strike strike1)) {
            return false;
        }
        return strike == strike1.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike);
    }

    @Override
    public String toString() {
        if (this.strike == ZERO_COUNT) {
            return NO_STRIKE_MESSAGE;
        }
        return this.strike + STRIKE_MESSAGE;
    }
}
