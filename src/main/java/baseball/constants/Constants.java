package baseball.constants;

public enum Constants {
    VALID_NUMBER_LENGTH(3),
    REQUIRED_NUMBERS_TO_MATCH(3),
    REQUIRED_STRIKES_FOR_WIN(3),
    NUMBER_LENGTH(3),
    MIN_RANDOM_NUMBER(1),
    MAX_RANDOM_NUMBER(9);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
