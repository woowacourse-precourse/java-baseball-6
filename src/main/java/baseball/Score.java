package baseball;

public class Score {
    private final Integer strike;
    private final Integer ball;

    private Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public static Score of(Integer strike, Integer ball) {
        return new Score(strike, ball);
    }
}
