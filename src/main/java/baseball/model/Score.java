package baseball.model;

public record Score(int strikes, int balls) {
    static final int MAX_STRIKES = 3;

    public boolean isGameWon() {
        return strikes == MAX_STRIKES;
    }

    public boolean isNothing() {
        return strikes == 0 && balls == 0;
    }

    public boolean isStrike() {
        return strikes > 0;
    }

    public boolean isBall() {
        return balls > 0;
    }
}
