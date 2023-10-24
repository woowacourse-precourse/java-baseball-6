package baseball;

public class Result {
    private final int strike;
    private final int ball;

    public Result(final int strike, final int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object obj) {
        Result other = (Result) obj;
        return this.strike == other.strike && this.ball == other.ball;
    }
}
