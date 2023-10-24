package baseball.model;

public class Result {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }
}
