package baseball.domain;

public class Hint {

    private Integer strike;
    private Integer ball;

    public Hint(Integer strike, Integer ball) {
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
