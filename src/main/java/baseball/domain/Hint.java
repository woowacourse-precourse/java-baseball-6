package baseball.domain;

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
        if (strike > 0) {
            return true;
        }
        return false;
    }

    public boolean isBallExist() {
        if (ball > 0) {
            return true;
        }
        return false;
    }

    public boolean isThreeStrike() {
        if (strike == 3) {
            return true;
        }
        return false;
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
