package baseball;

import baseball.ball.BallStatus;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public void report(BallStatus status) {
        if (!status.isNotNothing()) {
            return;
        }
        if (status.isStrike()) {
            this.strike += 1;
        }
        if (status.isBall()) {
            this.ball += 1;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isGameEnd() {
        return strike == 3;
    }
}
