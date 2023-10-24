package baseball;

public enum MatchState {
    BALL(0), STRIKE(1), NOTHING(2);

    private final int value;

    MatchState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
