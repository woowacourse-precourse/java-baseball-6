package baseball.constant;

public enum NumberConstant {
    INPUT_LENGTH(3),
    RESTART_INPUT_LENGTH(1),

    THREE_STRIKE(3);

    private final int number;

    NumberConstant(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}