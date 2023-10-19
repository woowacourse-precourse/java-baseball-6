package baseball;

public enum BaseballRole {
    MAX_BASEBALL_NUMBER_SIZE(3),
    MIN_BASEBALL_NUMBER(1),
    MAX_BASEBALL_NUMBER(9);

    private final int value;

    BaseballRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
