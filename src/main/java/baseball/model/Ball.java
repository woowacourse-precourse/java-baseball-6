package baseball.model;

import static baseball.util.AppConstants.INT_MAX_NUMBER;
import static baseball.util.AppConstants.INT_MIN_NUMBER;
import static baseball.util.AppConstants.OUT_OF_RANGE_MESSAGE;

import java.util.Objects;

public class Ball {
    private static final char CHAR_MIN_NUMBER = '1';
    private static final char CHAR_MAX_NUMBER = '9';

    private final Integer number;

    public Ball(char val) {
        this.number = validateIsNaturalNumber(val);
    }

    public Ball(int val) {
        this.number = validateIsInRange(val);
    }

    public static boolean equals(Ball a, Ball b) {
        return Objects.equals(a.number, b.number);
    }

    private Integer validateIsNaturalNumber(char val) {
        if (val < CHAR_MIN_NUMBER || val > CHAR_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return Character.getNumericValue(val);
    }

    private Integer validateIsInRange(int val) {
        if (val < INT_MIN_NUMBER || val > INT_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return val;
    }
}
