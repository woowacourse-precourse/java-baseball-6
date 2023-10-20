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

    public BaseballMatchResult match(BaseballState other) {
        final var matcher = new BaseballMatcher(this);
        var ball = 0;
        var strike = 0;

        for (int i = 0; i < MAX_MATCH; i++) {
            final var value = other.nth(i);
            strike += BooleanUtil.booleanToInt(matcher.checkStrike(i, value));
            ball += BooleanUtil.booleanToInt(matcher.checkBall(i, value));

        }
        return new BaseballMatchResult(ball, strike);
    }
}
