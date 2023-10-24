package baseball.enums;

public enum NumberEnum {
    START_NUMBER(1),
    END_NUMBER(9),
    NUMBER_LENGTH(3);

    private final int value;

    NumberEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static boolean isNotInRange(int number) {
        return number < START_NUMBER.getValue() || number > END_NUMBER.getValue();
    }
}
