package baseball.model;

import static baseball.util.AppConstants.INT_MAX_NUMBER;
import static baseball.util.AppConstants.INT_MIN_NUMBER;
import static baseball.util.AppConstants.OUT_OF_RANGE_MESSAGE;

import java.util.Objects;

public class Ball {

    private final Integer number;


    public Ball(int intInput) {
        this.number = validateIsInRange(intInput);
    }

    public static boolean equals(Ball a, Ball b) {
        return Objects.equals(a.number, b.number);
    }

    private Integer validateIsInRange(int intInput) {
        if (intInput < INT_MIN_NUMBER || intInput > INT_MAX_NUMBER) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return intInput;
    }
}
