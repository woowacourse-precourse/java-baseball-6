package baseball.domain;

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

    public String getStrikeString() {
        return strike + "스트라이크";
    }

    public String getBallString() {
        return ball + "볼";
    }

    public String getNothingString() {
        return "낫싱";
    }
}
