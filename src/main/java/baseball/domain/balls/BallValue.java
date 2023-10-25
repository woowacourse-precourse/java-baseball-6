package baseball.domain.balls;

import baseball.validator.IntegerValidators;
import java.util.Objects;

public class BallValue {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;

    private final int value;

    public BallValue(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        IntegerValidators.validateRange(value, MIN_VALUE, MAX_VALUE);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BallValue otherBallValue = (BallValue) obj;
        return value == otherBallValue.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
