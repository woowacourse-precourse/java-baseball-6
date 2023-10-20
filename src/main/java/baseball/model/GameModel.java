package baseball.model;

public class GameModel {
    private int strike;
    private int ball;
    private int nothing;
    private boolean isRunning;

    public GameModel() {
        this.isRunning = true;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getNothing() {
        return nothing;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public void setNothing(int nothing) {
        this.nothing = nothing;
    }

    public boolean isRunning() {
        return isRunning;
    }
}
