package baseball.domain;

import java.util.Objects;

public class PlayResult {
    private static final int INITIAL_COUNT = 0;

    private int strike;
    private int ball;

    PlayResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public PlayResult() {
        this(INITIAL_COUNT, INITIAL_COUNT);
    }

    public void record(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strike++;
            return;
        }
        if (ballStatus == BallStatus.BALL) {
            ball++;
        }
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
