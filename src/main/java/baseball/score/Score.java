package baseball.score;

import static baseball.constant.Error.*;
import static baseball.constant.Message.*;
import static baseball.constant.Rule.*;

public class Score {
    private final int strike;
    private final int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
        checkValidScore();
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return NOTHING.getMessage();
        }

        String output = "";
        if (ball != 0) {
            output = ball + BALL.getMessage();
        }
        if (strike != 0) {
            output += strike + STRIKE.getMessage();
        }
        return output;
    }

    private void checkValidScore() {
        if (strike < 0 || strike > SIZE.getValue())
            throw new IllegalArgumentException(NOT_VALID_SCORE.getMessage());

        if (ball < 0 || ball > SIZE.getValue())
            throw new IllegalArgumentException(NOT_VALID_SCORE.getMessage());

        if (ball + strike < 0 || ball + strike > SIZE.getValue())
            throw new IllegalArgumentException(NOT_VALID_SCORE.getMessage());
    }
}
