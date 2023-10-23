package baseball.entity;

public class GameResult {
    private Strike strike;
    private Ball ball;
    private boolean isGameEnded;

    public GameResult(Strike strike, Ball ball, boolean isGameEnded) {
        this.strike = strike;
        this.ball = ball;
        this.isGameEnded = isGameEnded;
    }

    public Strike getStrike() {
        return strike;
    }

    public Ball getBall() {
        return ball;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded() {
        this.isGameEnded = true;
    }

    public void setGameRestart() {
        this.isGameEnded = false;
    }

    public void resetScore() {
        strike.resetScore();
        ball.resetScore();
    }
}
