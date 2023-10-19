package baseball;

public enum Constants {
    RANDOM_NUMBER_LOWER_BOUND(1),
    RANDOM_NUMBER_UPPER_BOUND(9),
    NUM_DIGITS(3);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
