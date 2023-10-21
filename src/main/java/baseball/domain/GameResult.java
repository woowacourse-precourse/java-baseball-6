package baseball.domain;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBallCount() {
        return ball;
    }

    public int getStrikeCount() {
        return strike;
    }

    public boolean isWin() {
        return strike == 3;
    }
}
