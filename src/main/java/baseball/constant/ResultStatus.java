package baseball.constant;

public enum ResultStatus {
    FINISHED,
    CONTINUE;

    public boolean isFinished() {
        return this == FINISHED;
    }
}
