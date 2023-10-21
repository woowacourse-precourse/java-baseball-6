package baseball.state;

import static baseball.constant.BaseballConstants.MAX_MATCH;
import static baseball.constant.BaseballStrings.BALL_MESSAGE;
import static baseball.constant.BaseballStrings.NOTHING_MESSAGE;
import static baseball.constant.BaseballStrings.STRIKE_MESSAGE;

import baseball.util.Assertions;

public class BaseballStateMatchResult {
    private final int ball;
    private final int strike;

    public BaseballStateMatchResult(int _ball, int _strike) {
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
        final var stringBuilder = new StringBuilder();
        if (ball != 0) {
            stringBuilder.append(ball);
            stringBuilder.append(BALL_MESSAGE);
        }
        if (ball != 0 && strike != 0) {
            stringBuilder.append(" ");
        }
        if (strike != 0) {
            stringBuilder.append(strike);
            stringBuilder.append(STRIKE_MESSAGE);
        }
        if (strike == 0 && ball == 0) {
            stringBuilder.append(NOTHING_MESSAGE);
        }
        return stringBuilder.toString();
    }
}
