package baseball.domain.result;

public class Result {

    private final Integer ball;
    private final Integer strike;

    public Result(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }
}
