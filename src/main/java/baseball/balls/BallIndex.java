package baseball.balls;

import baseball.validators.BallIndexValidators;
import java.util.Objects;

public class BallIndex {

    private final int index;

    public BallIndex(int index) {
        BallIndexValidators.validateIndexRange(index);
        this.index = index;
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
