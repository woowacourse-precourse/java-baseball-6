package baseball.constant;

import java.util.Arrays;

public enum RetryStatus {
    KEEP_GOING(1),
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

    public Integer toRetryCommand() {
        return this.retryCommand;
    }

    public boolean isKeepGoing() {
        return this == KEEP_GOING;
    }
}
