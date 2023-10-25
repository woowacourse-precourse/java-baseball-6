package baseball.Enum;

public enum ResultCase {
    NOTHING,
    BALL,
    STRIKE,
    BALL_AND_STRIKE;

    public ResultCase next(int i) {
        return values()[ordinal() + i];
    }
}
