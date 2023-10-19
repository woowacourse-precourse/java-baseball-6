package baseball.common;

public enum Size {
    MIN(1),
    MAX(9),
    NUMBER(3);

    private final int value;

    Size(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
