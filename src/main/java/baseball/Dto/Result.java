package baseball.Dto;

public class Result {
    private int strike;
    private int ball;
    private static Result instance;

    private Result() {}

    public static synchronized Result getInstance() {
        if (instance == null) {
            instance = new Result();
        }
        return instance;
    }

    public void createResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }
    public int requestStrike() {
        return this.strike;
    }

    public int requestBall() {
        return this.ball;
    }
}
