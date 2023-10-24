package baseball;

public class GameResult {

    private final int strikes;
    private final int balls;

    public GameResult(final int strikes, final int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean hasBalls() {
        return balls > 0;
    }

    public boolean hasStrikes() {
        return strikes > 0;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public boolean isAllStrikes() {
        return strikes == GameConstants.NUMBER_LENGTH;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
