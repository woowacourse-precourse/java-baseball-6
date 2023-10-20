package game;

import constants.NumberConstants;

public class BallCounts {

    private final int ball;
    private final int strike;

    public BallCounts() {
        this.ball = 0;
        this.strike = 0;
    }

    public BallCounts(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isFinish() {
        return this.strike == NumberConstants.MAX_STRIKE;
    }

    @Override
    public String toString() {
        return CountsMessage.toMessage(ball, strike);
    }
}
