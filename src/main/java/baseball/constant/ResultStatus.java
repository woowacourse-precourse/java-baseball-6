package baseball.constant;

public enum ResultStatus {
    SUCCESS,
    CONTINUE;

    public boolean isContinue() {
        return this == CONTINUE;
    }
}
