package domain.ball;

import java.util.Objects;
import util.validator.BallNumberValidator;

public class BallNumber {

    private final int ballNumber;

    public BallNumber(int ballNumber) {
        BallNumberValidator numberValidator = BallNumberValidator.getInstance();
        numberValidator.validate(ballNumber);
        this.ballNumber = ballNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BallNumber number = (BallNumber) o;
        return ballNumber == number.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

}
