package baseball.state;

import baseball.constant.BaseballString;
import baseball.util.Assertions;

public class BaseballResult {
    private final int MAX_MATCH = 3;
    private final int ball;
    private final int strike;

    public BaseballResult(int _ball, int _strike) {
        Assertions.assertInRange(_ball, 0, MAX_MATCH);
        Assertions.assertInRange(_strike, 0, MAX_MATCH);
        Assertions.assertInRange(_ball + _strike, 0, MAX_MATCH);

        ball = _ball;
        strike = _strike;
    }

    public boolean isGameEnd() {
        return strike == MAX_MATCH;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball);
            sb.append(BaseballString.BALL);
        }
        if (ball != 0 && strike != 0) {
            sb.append(" ");
        }
        if (strike != 0) {
            sb.append(strike);
            sb.append(BaseballString.STRIKE);
        }
        if (strike == 0 && ball == 0) {
            sb.append(BaseballString.NOTHING);
        }
        return sb.toString();
    }
}
