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

    public boolean isThreeStrike() {
        return this.strike == 3;
    }

    public boolean isNothing() {
        return ball == 0 && strike == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

}
