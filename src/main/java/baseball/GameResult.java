package baseball;

public class GameResult {
    private final int strikes;
    private final int balls;

    public GameResult(final int strikes, final int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
