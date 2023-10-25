package baseball;

public enum NumericRange {
    COUNT(3),
    MAX_VALUE(9),
    MIN_VALUE(1);

    private final int number;

    NumericRange(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
