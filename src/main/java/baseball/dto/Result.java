package baseball.dto;

import java.util.Objects;

//TODO: IDE에서 Record로 바꿀 수 있다네요!?
public class Result {
    private final Integer strike;
    private final Integer ball;
    private final Integer NOTHING_VALUE = 0;

    public Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public Boolean isNothing() {
        return Objects.equals(strike, NOTHING_VALUE) && Objects.equals(ball, NOTHING_VALUE);
    }
}
