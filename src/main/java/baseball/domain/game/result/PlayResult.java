package baseball.domain.game.result;

import baseball.domain.status.BallStatus;
import baseball.utils.Constants;

import java.util.Map;
import java.util.Objects;

public class PlayResult {
    private static final int THREE = 3;

    private final int strike;
    private final int ball;

    public PlayResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static PlayResult from(Map<BallStatus, Integer> result) {
        int strike = result.getOrDefault(BallStatus.STRIKE, Constants.INITIAL_COUNT);
        int ball = result.getOrDefault(BallStatus.BALL, Constants.INITIAL_COUNT);

        return new PlayResult(strike, ball);
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
