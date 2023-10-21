package model.referee;

public class GameScoreboard {

    private final int strike;
    private final int ball;

    public GameScoreboard() {
        this.strike = 0;
        this.ball = 0;
    }

    private GameScoreboard(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public GameScoreboard incrementStrike() {
        return new GameScoreboard(strike + 1, ball);
    }

    public GameScoreboard incrementBall() {
        return new GameScoreboard(strike, ball + 1);
    }
}
