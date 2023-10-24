package baseball;

import static baseball.BaseballGame.ANSWER_DIGIT;

import java.util.StringJoiner;

public class HintScore {

    private int strike;
    private int ball;

    private static final String PRINT_BALL_FORMAT = "%d볼";
    private static final String PRINT_STRIKE_FORMAT = "%d스트라이크";
    private static final String PRINT_NOTHING_FORMAT = "낫싱";


    public void raiseStrike() {
        strike++;
    }

    public void raiseBall() {
        ball++;
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
