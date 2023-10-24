package baseball.utils;

public enum Range {
    MIN(1),
    MAX(9),
    VALID_INPUT_SIZE(3);
    private final int numberRange;

    Range(int range) {
        this.numberRange = range;
    }

    public int getRange() {
        return numberRange;
    }
}
