package baseball.constant;

public enum ContinueFlag {
    CONTINUE(1),
    DONE(2),
    ;
    private final int value;

    ContinueFlag(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
