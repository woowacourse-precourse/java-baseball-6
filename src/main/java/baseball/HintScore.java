package baseball;

import static baseball.BaseballGame.ANSWER_DIGIT;

import java.util.List;
import java.util.StringJoiner;

public class HintScore {

    private int strike;
    private int ball;

    private static final String PRINT_BALL_FORMAT = "%d볼";
    private static final String PRINT_STRIKE_FORMAT = "%d스트라이크";
    private static final String PRINT_NOTHING_FORMAT = "낫싱";
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
            if (matchIndex != NOTHING_MATCH_INDEX) {
                raiseBall();
            }
        }
    }

    @Override
    public String toString() {
        if (isNothing()) {
            return PRINT_NOTHING_FORMAT;
        }
        StringJoiner stringJoiner = new StringJoiner(" ");
        if (ball != 0) {
            stringJoiner.add(String.format(PRINT_BALL_FORMAT, ball));
        }
        if (strike != 0) {
            stringJoiner.add(String.format(PRINT_STRIKE_FORMAT, strike));
        }
        return stringJoiner.toString();
    }

    private boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isGameOver() {
        return strike == ANSWER_DIGIT;
    }
}
