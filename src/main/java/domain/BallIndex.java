package domain;

import util.validator.BallIndexValidator;

public class BallIndex {

    int ballIndex;

    public BallIndex(int ballIndex) {
        BallIndexValidator ballIndexValidator = BallIndexValidator.getInstance();
        ballIndexValidator.validate(ballIndex);
        this.ballIndex = ballIndex;
    }

    public int getBallIndex() {
        return ballIndex;
    }

}
