package baseball.domain;

import static baseball.constant.HintMessage.NOTHING;
import static baseball.constant.HintMessage.ONLY_BALL;
import static baseball.constant.HintMessage.ONLY_STRIKE;
import static java.lang.String.format;
import static java.lang.String.join;

import java.util.ArrayList;

public class Hint {

    private int strike;

    private int ball;

    public Hint() {
        strike = 0;
        ball = 0;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public boolean isHintNothing() {
        return isStrikeExist() && isBallExist();
    }

    public boolean isStrikeExist() {
        return strike > 0;
    }

    public boolean isBallExist() {
        return ball > 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public String toString() {
        ArrayList<String> resultString = new ArrayList<>();
        if (!isBallExist() && !isStrikeExist()) {
            return getNothingString();
        }
        if (isBallExist()) {
            resultString.add(getBallString());
        }
        if (isStrikeExist()) {
            resultString.add(getStrikeString());
        }
        return join(" ", resultString);
    }

    public String getStrikeString() {
        return format(ONLY_STRIKE.getMessage(), strike);
    }

    public String getBallString() {
        return format(ONLY_BALL.getMessage(), ball);
    }

    public String getNothingString() {
        return NOTHING.getMessage();
    }
}
