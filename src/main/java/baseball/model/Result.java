package baseball.model;

public class Result {

    private int strike = 0;
    private int ball = 0;

    public void countUpStrike() {
        this.strike++;
    }

    public void countUpBall() {
        this.ball++;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (ball == 0) {
            return strike + "스트라이크";
        } else if (strike == 0) {
            return ball + "볼";
        }
        return ball + "볼 " + strike + "스트라이크";
    }

    public int getStrike() {
        return strike;
    }
}
