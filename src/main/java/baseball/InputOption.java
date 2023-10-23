package baseball;

public enum InputOption {
    ZERO(0),
    RESTART_NUMBER(1),
    QUIT_NUMBER(2),
    CORRECT_INPUT_RANGE(3);

    private final int value;

    InputOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
