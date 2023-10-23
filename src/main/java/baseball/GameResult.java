package baseball;

public class GameResult {
    private int ball;
    private int strike;

    public GameResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }

    @Override
    public String toString() {
        if (ball > 0 && strike == 0) {
            return ball + "볼";
        } else if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else {
            return "낫싱";
        }
    }
}
