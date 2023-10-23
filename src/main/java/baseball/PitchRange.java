package baseball;

public enum PitchRange {
    MIN_STRIKES(0),
    MAX_STRIKES(3),
    MIN_BALLS(0);
    private final int value;

    PitchRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
