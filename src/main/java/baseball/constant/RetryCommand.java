package baseball.constant;

import java.util.Arrays;

public enum RetryCommand {

    RETRY(1),
    END(2);

    private final int command;

    RetryCommand(int command) {
        this.command = command;
    }

    public boolean isEnd() {
        return this == END;
    }
    public static RetryCommand getRetryCommand(int command) {
        return Arrays.stream(RetryCommand.values())
                .filter(value -> value.command == command)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_RETRY_COMMAND.getMessage()));
    }
}
