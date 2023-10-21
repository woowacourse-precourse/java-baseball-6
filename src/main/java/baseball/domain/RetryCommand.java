package baseball.domain;

import java.util.Arrays;

public enum RetryCommand {
    RETRY(1), EXIT(2);

    private final Integer command;

    RetryCommand(int command) {
        this.command = command;
    }

    public static RetryCommand convertTypeCommand(int input) {
        return Arrays.stream(RetryCommand.values())
                .filter(retryCommand -> retryCommand.command.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }
}
