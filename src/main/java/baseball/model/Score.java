package baseball.model;

import static baseball.model.enums.ScoreMessage.BALL;
import static baseball.model.enums.ScoreMessage.NOTHING;
import static baseball.model.enums.ScoreMessage.STRIKE;

public class Score {
    private static final int THREE_STRIKE = 3;
    private static final int NO_COUNT = 0;

    final int ball;
    final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public String toString() {
        if ((ball != NO_COUNT) && (strike != NO_COUNT)) {
            return strike + STRIKE.getMessage()
                    + " " + ball + BALL.getMessage();
        } else if (ball != NO_COUNT) {
            return ball + BALL.getMessage();
        } else if (strike != NO_COUNT) {
            return strike + STRIKE.getMessage();
        }
        return NOTHING.getMessage();
    }

    public boolean isThreeStrike() {
        return strike == THREE_STRIKE;
    }
}
