package baseball.constant;

public enum ResultStatus {
    SUCCESS,
    CONTINUE;

    public boolean isSuccess() {
        return this == SUCCESS;
    }
}
