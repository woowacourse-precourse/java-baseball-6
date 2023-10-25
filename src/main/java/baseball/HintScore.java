package baseball;

import static baseball.BaseballGame.ANSWER_DIGIT;
import static baseball.constant.PrintMessage.BALL_FORMAT;
import static baseball.constant.PrintMessage.NOTHING_FORMAT;
import static baseball.constant.PrintMessage.STRIKE_FORMAT;

import java.util.List;
import java.util.StringJoiner;

public class HintScore {

    private int strike;
    private int ball;

    private static final Integer NOTHING_MATCH_INDEX = -1;

    private void raiseStrike() {
        strike++;
    }

    private void raiseBall() {
        ball++;
    }

    public void calculateHint(final List<Integer> correctAnswer, final List<Integer> userAnswer) {
        for (int i = 0; i < userAnswer.size(); i++) {
            int matchIndex = correctAnswer.indexOf(userAnswer.get(i));
            if (matchIndex == i) {
                raiseStrike();
            }
            if (matchIndex != i && matchIndex != NOTHING_MATCH_INDEX) {
                raiseBall();
            }
        }
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return NOTHING_FORMAT;
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        if (ball != 0) {
            stringJoiner.add(String.format(BALL_FORMAT, ball));
        }
        if (strike != 0) {
            stringJoiner.add(String.format(STRIKE_FORMAT, strike));
        }
        return stringJoiner.toString();
    }

    private boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isGameOver() {
        return strike == ANSWER_DIGIT;
    }

    public void clear() {
        ball = 0;
        strike = 0;
    }
}
