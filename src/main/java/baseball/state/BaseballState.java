package baseball.state;

import static baseball.constant.BaseballConstants.MAX_MATCH;

import baseball.util.Assertions;
import baseball.util.BooleanUtil;
import java.util.List;

public class BaseballState {
    private final List<Integer> state;

    public BaseballState(List<Integer> _state) {
        Assertions.assertEqual(_state.size(), MAX_MATCH);
        state = _state;
    }

    public Integer nth(int n) {
        return state.get(n);
    }

    public BaseballStateMatchResult match(BaseballState other) {
        final var matcher = new BaseballStateMatchHelper(this);
        var ball = 0;
        var strike = 0;

        for (int i = 0; i < MAX_MATCH; i++) {
            final var value = other.nth(i);
            final var isStrike = matcher.checkStrike(i, value);
            final var isBall = matcher.checkBall(i, value);

            strike += BooleanUtil.booleanToInt(isStrike);
            ball += BooleanUtil.booleanToInt(isBall);

        }
        return new BaseballStateMatchResult(ball, strike);
    }
}
