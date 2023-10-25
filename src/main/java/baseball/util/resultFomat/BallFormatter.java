package baseball.util.resultFomat;

import baseball.model.BallCount;

public class BallFormatter implements ResultFormatter {
    private final int ball;

    public BallFormatter(int ball) {
        this.ball = ball;
    }

    @Override
    public String format() {
        return ball + BallCount.BALL.getBaseballjudgment();
    }
}

