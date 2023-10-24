package game;

import constants.Constants;

public class BallCount {

    private int strike;
    private int ball;

    public BallCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrike(int strike) {
        this.strike += strike;
    }

    public void addBall(int ball) {
        this.ball += ball;
    }

    public boolean isThreeStrike() {
        boolean flag = false;
        if (strike == Constants.BALL_SIZE) {
            flag = true;
        }
        return flag;
    }

    public String getBallCount() {
        StringBuffer sb = new StringBuffer();
        if (ball > 0) {
            sb.append(ball + Constants.BALL + " ");
        }
        if (strike > 0) {
            sb.append(strike + Constants.STRIKE);
        }
        if (ball == 0 && strike == 0) {
            sb.append(Constants.NOTHING);
        }
        return sb.toString();
    }
}
