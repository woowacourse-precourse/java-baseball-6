package baseball.balls;

import baseball.validators.IntegerValidators;
import java.util.Objects;

public class BallValue {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final int value;

    public BallValue(int value) {
        IntegerValidators.validateRange(value, MIN_VALUE, MAX_VALUE);
        this.value = value;
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
