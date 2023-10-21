package baseball.entity;

public class Result {

    private int ball;
    private int strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static Result createResult(int ball, int strike) {
        return new Result(ball, strike);
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean correctAnswer() {
        return strike == 3;
    }
}
