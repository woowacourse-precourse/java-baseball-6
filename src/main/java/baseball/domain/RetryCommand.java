package baseball.domain;

import java.util.Arrays;

public enum RetryCommand {

    RETRY("1"),
    QUIT("2");

    private final String number;

    RetryCommand(String number) {
        this.number = number;
    }

    public static RetryCommand findByInput(String input) {
        return Arrays.stream(RetryCommand.values())
                .filter(it -> it.number.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("1, 2만 입력 가능합니다."));
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }

}
