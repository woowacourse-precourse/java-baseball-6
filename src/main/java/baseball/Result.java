package baseball;

import static baseball.Exception.INVALID_STRIKE_OR_BALL_COUNT;

public record Result(Integer strike, Integer ball) {

    public Result {
        if (strike < 0 || ball < 0) {
            throw new IllegalArgumentException(INVALID_STRIKE_OR_BALL_COUNT.getMessage());
        }
    }

    public boolean isAllStrike() {
        return strike == 3;
    }
}
