package baseball.model;

public class Result {
    private final int strike;
    private final int ball;

    public Result(int strikes, int balls) {
        this.strike = strikes;
        this.ball = balls;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }
}
