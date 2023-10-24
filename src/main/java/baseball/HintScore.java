package baseball;

import java.util.StringJoiner;

public class HintScore {

    private int strike;
    private int ball;

    private static final String PRINT_BALL_FORMAT = "%d볼";

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
        return stringJoiner.toString();
    }
}
