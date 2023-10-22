package baseball.domain;

import baseball.util.ExceptionMessage;

import java.util.Arrays;

public enum RetryCommand {
    RETRY("1"), EXIT("2");

    private final String command;

    RetryCommand(String command) {
        this.command = command;
    }

    public static RetryCommand convertTypeCommand(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(retryCommand -> retryCommand.command.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.CHECK_RETRY.getMessage()));
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }
}
