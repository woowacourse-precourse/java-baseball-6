package baseball;

public class Result {

    private int ball;
    private int strike;

    public Result() {
    }

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
}
