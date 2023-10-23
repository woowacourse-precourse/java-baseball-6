package baseball.domain;

import baseball.domain.Ball;

public class GameResult {

    private final int strike;
    private final int ball;


    public GameResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isBallZero() {
        return ball == 0;
    }

    public boolean isStrikeZero() {
        return strike == 0;
    }

}
