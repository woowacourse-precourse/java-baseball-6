package baseball;

public class GameResult {
    private int strikes;
    private int balls;

    public GameResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public boolean isGameEnd() {
        return strikes == 3;
    }
}
