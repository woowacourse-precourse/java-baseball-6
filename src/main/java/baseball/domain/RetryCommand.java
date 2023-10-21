package baseball.domain;

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
                .orElseThrow(() -> new IllegalArgumentException("입력 값을 다시 한번 확인해주세요.(1,2)"));
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }
}
