package baseball.my_sol;

public enum NumStatus {
    STRIKE, BALL, NOTHING;

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
