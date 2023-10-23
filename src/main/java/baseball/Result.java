package baseball;

import static baseball.Constant.NUMBER_LENGTH;

public class Result {

    private int ball;
    private int strike;

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return (strike == 0) && (ball == 0);
    }

    public boolean isCorrect() {
        return strike == NUMBER_LENGTH;
    }
}
