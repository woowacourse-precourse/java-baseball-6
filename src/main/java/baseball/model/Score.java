package baseball.model;

public class Score {

    private static final Integer THREE_STRIKE = 3;

    private Integer strike;
    private Integer ball;

    public Score(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
