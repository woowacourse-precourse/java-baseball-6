package baseball;

import static baseball.Constant.*;

public class Result {
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return NOTHING_STRING;
        }
        else if (strike > 0 && ball == 0) {
            return strike + STRIKE_STRING;
        }
        else if (ball > 0 && strike == 0) {
            return ball + BALL_STRING;
        }
        return ball + BALL_STRING + " " + strike + STRIKE_STRING;
    }
}