package baseball;

public class BaseballInfo {
    private int strike;
    private int ball;
    private int out;

    public BaseballInfo(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void addStrike() {
        strike++;
    }

    public void addball() {
        ball++;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString();
    }
}
