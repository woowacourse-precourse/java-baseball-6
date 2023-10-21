package baseball.domain.game.result;

import baseball.domain.status.BallStatus;

import java.util.Objects;

public class PlayResult {
    private static final int INITIAL_COUNT = 0;
    private static final int THREE = 3;

    private int strike;
    private int ball;

    public PlayResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public PlayResult() {
        this(INITIAL_COUNT, INITIAL_COUNT);
    }

    public void record(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
            return;
        }
        if (ballStatus.isBall()) {
            ball++;
        }
    }

    public boolean isThreeStrike() {
        return strike == THREE;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayResult result = (PlayResult) o;
        return strike == result.strike && ball == result.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }
}
