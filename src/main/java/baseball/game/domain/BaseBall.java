package baseball.game.domain;

public class BaseBall {
    private final int strike;
    private final int ball;

    public BaseBall(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
