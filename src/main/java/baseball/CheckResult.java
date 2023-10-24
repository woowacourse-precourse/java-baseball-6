package baseball;

public enum CheckResult {
    NOTHING,
    BALL,
    STRIKE,
    BALL_AND_STRIKE;

    public CheckResult next(int i) {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + i];
    }
}
