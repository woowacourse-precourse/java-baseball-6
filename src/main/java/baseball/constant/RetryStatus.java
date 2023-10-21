package baseball.constant;

public enum RetryStatus {
    RETRY(1),
    FINISH(0);

    private final Integer retryCommand;

    RetryStatus(final Integer retryCommand) {
        this.retryCommand = retryCommand;
    }

    public Integer getRetryCommand() {
        return this.retryCommand;
    }
}
