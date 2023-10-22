package baseball.constant;

import java.util.Arrays;

public enum RetryStatus {
    RETRY(1),
    FINISH(2);

    private final Integer retryCommand;

    RetryStatus(final Integer retryCommand) {
        this.retryCommand = retryCommand;
    }

    public static RetryStatus valueOfCommand(final Integer command) {
        return Arrays.stream(values())
                .filter(value -> value.retryCommand.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getRetryCommand() {
        return this.retryCommand;
    }

    public boolean isFinish() {
        return this == FINISH;
    }
}
