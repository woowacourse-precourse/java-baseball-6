package baseball.domain.result;

public enum BallResult {
    STRIKE(3), BALL(2), NOTHING(1);

    private final int priority;

    BallResult(int priority) {
        this.priority = priority;
    }

    public int compare(BallResult result) {
        return Integer.compare(this.priority, result.priority);
    }

    public boolean isBall() {
        return this.equals(BALL);
    }

    public boolean isStrike() {
        return this.equals(STRIKE);
    }
}