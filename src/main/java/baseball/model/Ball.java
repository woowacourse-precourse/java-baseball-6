package baseball.model;

import static baseball.util.AppConstants.INT_MAX_NUMBER;
import static baseball.util.AppConstants.INT_MIN_NUMBER;
import static baseball.util.AppConstants.OUT_OF_RANGE_MESSAGE;

import java.util.Objects;

public class Ball {
    private static final char CHAR_MIN_NUMBER = (char)(INT_MIN_NUMBER + '0');
    private static final char CHAR_MAX_NUMBER = (char)(INT_MAX_NUMBER + '0');

    private final Integer number;

    public Ball(char charInput) {
        this.number = validateIsNaturalNumber(charInput);
    }

    public Ball(int intInput) {
        this.number = validateIsInRange(intInput);
    }

    public static boolean equals(Ball a, Ball b) {
        return Objects.equals(a.number, b.number);
    }

    private Integer validateIsNaturalNumber(char charInput) {
        if (charInput < CHAR_MIN_NUMBER || charInput > CHAR_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return Character.getNumericValue(charInput);
    }

    private Integer validateIsInRange(int intInput) {
        if (intInput < INT_MIN_NUMBER || intInput > INT_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return intInput;
    }
}
