package baseball;

public enum BallScore {
    NOTHING, BALL, STRIKE;

    public boolean isStrike() {
        return this.equals(STRIKE);
    }

    public boolean isBall() {
        return this.equals(BALL);
    }
}
