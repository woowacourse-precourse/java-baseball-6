package baseball;

public class HintResult {

    private int ball;
    private int strike;

    public HintResult() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }
}
