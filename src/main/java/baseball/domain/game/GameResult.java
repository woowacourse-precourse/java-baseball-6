package baseball.domain.game;

public class GameResult {

    private final int strike;
    private final int ball;

    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean hasStrike() {
        return strike > 0;
    }

    public boolean hasBall() {
        return ball > 0;
    }

    public boolean hasEndCondition() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
