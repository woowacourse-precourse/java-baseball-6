package baseball.domain.game.result;

import baseball.domain.status.BallStatus;
import baseball.utils.Constants;

import java.util.Map;

public record PlayResult(int strike, int ball) {
    private static final int THREE = 3;

    public static PlayResult from(Map<BallStatus, Integer> result) {
        int strike = result.getOrDefault(BallStatus.STRIKE, Constants.INITIAL_COUNT);
        int ball = result.getOrDefault(BallStatus.BALL, Constants.INITIAL_COUNT);

        return new PlayResult(strike, ball);
    }

    public boolean isThreeStrike() {
        return strike == THREE;
    }
}
