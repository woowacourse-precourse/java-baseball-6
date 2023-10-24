package baseball.domain;

public enum ResultCase {
    NOTHING,
    BALL,
    STRIKE,
    BALL_AND_STRIKE;

    public ResultCase next(int i) {
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + i];
    }
}
