package baseball.domain;

import static baseball.domain.number.NumberConstant.NUMBER_COUNT;

public class Result {
    private Integer ball;
    private Integer strike;

    private Result() {
    }

    public static Result create(Integer ball, Integer strike) {
        Result result = new Result();
        result.setBall(ball);
        result.setStrike(strike);

        return result;
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

    private void setBall(Integer ball) {
        this.ball = ball;
    }

    private void setStrike(Integer strike) {
        this.strike = strike;
    }
}
