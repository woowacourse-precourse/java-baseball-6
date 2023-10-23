package baseball;

public enum BaseballValues {

    MAX_NUMBER_LENGTH(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private final int value;

    BaseballValues(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
