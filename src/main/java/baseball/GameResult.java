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
}
