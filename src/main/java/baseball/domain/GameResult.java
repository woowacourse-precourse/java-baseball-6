package baseball.domain;

public class GameResult {
    private int strike;
    private int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isGameOver() {
        return strike == 3;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean hasBall() {
        return 0 < ball;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasStrike() {
        return 0 < strike;
    }

    public int getStrike() {
        return strike;
    }
}
