package baseball.domain;

import baseball.common.config.BaseballMessageConst;

public enum Ball {
    ZERO(0), ONE(1), TWO(2), THREE(3);
    private final int ballCount;

    Ball(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public static Ball of(int ballCount) {
        for (Ball ball : values()) {
            if (ball.ballCount == ballCount) {
                return ball;
            }
        }
        throw new IllegalArgumentException(BaseballMessageConst.OUT_OF_RANGE_BALL_ERROR);
    }
}
