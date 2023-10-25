package baseball.domain.balls;

import baseball.validator.IntegerValidators;
import java.util.Objects;

public class BallIndex {

    private static final int MIN_INDEX = 0;
    private static final int MAX_INDEX = 3;

    private final int index;

    public BallIndex(int index) {
        validateRange(index);
        this.index = index;
    }

    private void validateRange(int index) {
        IntegerValidators.validateRange(index, MIN_INDEX, MAX_INDEX);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BallIndex otherBallIndex = (BallIndex) obj;
        return index == otherBallIndex.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

}
