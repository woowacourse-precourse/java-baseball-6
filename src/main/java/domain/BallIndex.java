package domain;

import java.util.Objects;
import util.validator.BallIndexValidator;

public class BallIndex {

    private final int ballIndex;

    public BallIndex(int ballIndex) {
        BallIndexValidator ballIndexValidator = BallIndexValidator.getInstance();
        ballIndexValidator.validate(ballIndex);
        this.ballIndex = ballIndex;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallIndex index = (BallIndex) o;
        return ballIndex == index.ballIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballIndex);
    }
}


