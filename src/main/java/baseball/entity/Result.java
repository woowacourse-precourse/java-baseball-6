package baseball.entity;

public class Result {

    private int ball;
    private int Strike;

    private Result(int ball, int strike) {
        this.ball = ball;
        Strike = strike;
    }

    public static Result createResult(int ball, int strike) {
        return new Result(ball, strike);
    }
}
