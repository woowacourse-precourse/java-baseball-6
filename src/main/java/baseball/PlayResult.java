package baseball;

public class PlayResult {

    private int strike = 0;
    private int ball = 0;

    public void result(BallResultEnum result) {
        if (result.equals(BallResultEnum.STRIKE)) {
            strike++;
        }

        if (result.equals(BallResultEnum.BALL)) {
            ball++;
        }

    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        if (strike + ball == 0) {
            return true;
        }
        return false;
    }

    public boolean isBallAndStrike() {
        if (strike > 0 && ball > 0) {
            return true;
        }
        return false;
    }

    public boolean isBall() {
        if (strike == 0 && ball > 0) {
            return true;
        }
        return false;
    }

    public boolean isStrike() {
        if (strike > 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
