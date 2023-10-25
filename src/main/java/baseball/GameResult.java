package baseball;

public class GameResult {

    private int ball;
    private int strike;

    public GameResult() {
        this.ball = 0;
        this.strike = 0;
    }

    public void addBall() {
        this.ball++;
    }

    public void addStrike() {
        this.strike++;
    }

    public boolean isWin() {
        return this.strike == 3;
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
