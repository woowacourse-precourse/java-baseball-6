package baseball.util.resultFomat;

import static baseball.util.Constants.RESULT_SPACE;

import baseball.model.BallCount;

public class BallAndStrikeFormatter implements ResultFormatter {
    private final int ball;
    private final int strike;

    public BallAndStrikeFormatter(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public String format() {
        return ball + BallCount.BALL.getBaseballjudgment() + RESULT_SPACE + strike
                + BallCount.STRIKE.getBaseballjudgment();
    }
}