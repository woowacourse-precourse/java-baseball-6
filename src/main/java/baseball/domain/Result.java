package baseball.domain;

import static baseball.domain.Numbers.NUMBER_COUNT;

public class Result {
    private final Integer ball;
    private final Integer strike;

    public Result(Integer ball, Integer strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isFinish() {
        return strike.equals(NUMBER_COUNT);
    }

    public boolean isContinue() {
        return !strike.equals(NUMBER_COUNT);
    }

    public boolean isNon() {
        return ball.equals(0) && strike.equals(0);
    }

    public Integer getBall() {
        return ball;
    }

    public Integer getStrike() {
        return strike;
    }


}
