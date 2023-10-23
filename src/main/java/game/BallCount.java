package game;

import constants.MessageConstants;

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
        if (strike == 3) {
            flag = true;
        }
        return flag;
    }

    public String getBallCount() {
        StringBuffer sb = new StringBuffer();
        if (ball > 0) {
            sb.append(ball + MessageConstants.BALL);
            sb.append(" ");
        }
        if (strike > 0) {
            sb.append(strike + MessageConstants.STRIKE);
        }
        if (ball == 0 && strike == 0) {
            sb.append(MessageConstants.NOTHING);
        }
        return sb.toString();
    }
}
