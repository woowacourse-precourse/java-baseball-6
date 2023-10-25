package baseball.common;

public enum NumberConstants {
    NUMBER_LENGTH(3),
    NUMBER_RANGE_MIN(1),
    NUMBER_RANGE_MAX(9),
    SUCCESS_GAME_STRIKE_NUMBER(3);

    private final int value;

    NumberConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
