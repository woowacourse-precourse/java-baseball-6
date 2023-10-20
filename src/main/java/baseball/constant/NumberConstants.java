package baseball.constant;

public enum NumberConstants {
    NUMBER_SIZE(3),
    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private final Integer value;

    NumberConstants(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
