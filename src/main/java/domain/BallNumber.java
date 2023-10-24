package domain;

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

}
