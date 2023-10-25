package baseball;

public class Count {

    private int strike;
    private int ball;

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }

    public String getResultString() {
        if (strike == 0 && ball == 0) {
            return GameConstant.NOTHING;
        }
        if (strike == 0) {
            return ball + GameConstant.BALL;
        }
        if (ball == 0) {
            return strike + GameConstant.STRIKE;
        }
        return ball + GameConstant.BALL + " " + strike + GameConstant.STRIKE;
    }
}
