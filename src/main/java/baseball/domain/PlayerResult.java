package baseball.domain;


import baseball.constant.errorMessage.InputError;
import baseball.constant.errorMessage.RunError;

public class PlayerResult {

    private final Integer MAX_STRIKE_COUNT = 3;
    private final Integer MAX_BALL_COUNT = 3;

    private final Integer MIN_STRIKE_COUNT = 0;

    private final Integer MIN_BALL_COUNT = 0;
    private final Integer strike;
    private final Integer ball;

    public PlayerResult(Integer strike, Integer ball) {
        validateStrikeRange(strike);
        validateBallRange(ball);
        this.strike = strike;
        this.ball = ball;
    }

    private void validateStrikeRange(Integer strike) {
        if (MIN_STRIKE_COUNT > strike || strike > MAX_STRIKE_COUNT)
            throw new IllegalStateException(RunError.WRONG_STRIKE_RANGE);
    }

    private void validateBallRange(Integer ball) {
        if (MIN_BALL_COUNT > ball || ball > MAX_BALL_COUNT)
            throw new IllegalStateException(RunError.WRONG_BALL_RANGE);
    }


    public Integer getStrike() {
        return this.strike;
    }

    public Integer getBall() {
        return this.ball;
    }

}
