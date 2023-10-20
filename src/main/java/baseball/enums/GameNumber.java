package baseball.enums;

public enum GameNumber {

    MAX_LENGTH(3),
    MAX_VALUE(9),
    MIN_VALUE(1);

    private final int value;

    GameNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}