package baseball.model;

public record Score(int strikes, int balls) {

    public boolean isGameWon() {
        return strikes == 3;
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
