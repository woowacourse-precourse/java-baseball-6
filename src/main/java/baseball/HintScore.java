package baseball;

import java.util.StringJoiner;

public class HintScore {

    private int strike;
    private int ball;

    private static final String PRINT_BALL_FORMAT = "%d볼";
    private static final String PRINT_STRIKE_FORMAT = "%d스트라이크";

    public void raiseStrike() {
        strike++;
    }

    public void raiseBall() {
        ball++;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        if (ball != 0) {
            stringJoiner.add(String.format(PRINT_BALL_FORMAT, ball));
        }
        if (strike != 0) {
            stringJoiner.add(String.format(PRINT_STRIKE_FORMAT, strike));
        }
        return stringJoiner.toString();
    }
}
