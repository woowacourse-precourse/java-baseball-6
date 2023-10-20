package baseball;

public enum Constants {
    NUMBER_LOWER_BOUND(1),
    NUMBER_UPPER_BOUND(9),
    SIZE_OF_DIGITS(3);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
