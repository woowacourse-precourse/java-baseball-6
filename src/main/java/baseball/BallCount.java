package baseball;

public class BallCount {

    private int strike = 0;
    private int ball = 0;

    public void addStrikeCount() {
        strike++;
    }

    public void addBallCount() {
        ball++;
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
            sb.append(ball + "볼 ");
        }
        if (strike > 0) {
            sb.append(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            sb.append("낫싱");
        }
        return sb.toString();
    }
}
