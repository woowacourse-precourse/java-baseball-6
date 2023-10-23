package baseball.model;

public class BaseballGameStatus {
    private int ball;
    private int strike;
    private boolean gameInProgress;

    public BaseballGameStatus() {
        this.reset();
    }

    public void reset() {
        this.ball = 0;
        this.strike = 0;
        this.gameInProgress = true;
    }

    public void setGameInProgress(boolean gameInProgress) {
        this.gameInProgress = gameInProgress;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isGameInProgress() {
        return gameInProgress;
    }

    public void increaseBall() {
        this.ball = this.ball  + 1;
    }

    public void increaseStrike() {
        this.strike = this.strike  + 1;
    }

}
