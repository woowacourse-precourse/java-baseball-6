package baseball.domain;

import static baseball.constants.BaseballGameConstants.THREE;
import static baseball.constants.BaseballGameConstants.ZERO;

public class GameResult {

    private int strike = ZERO;
    private int ball = ZERO;

    public void plusStrike() {
        strike++;
    }

    public void plusBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == ZERO && ball == ZERO;
    }

    public boolean hasBall() {
        return ball != ZERO;
    }

    public boolean hasStrike() {
        return strike != ZERO;
    }

    public boolean isThreeStrike() {
        return strike == THREE;
    }

    public void reset() {
        this.strike = ZERO;
        this.ball = ZERO;
    }
}
