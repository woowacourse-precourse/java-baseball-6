package baseball.model;

public enum CompareResult {
    STRIKE, BALL, NOTHING;

    public boolean isNothing() {
        return this == NOTHING;
    }
}
