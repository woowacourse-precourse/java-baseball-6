package baseball.constant;

import java.util.Arrays;

public enum RetryStatus {
    KEEP_GOING(1),
    FINISH(2);

    private final Integer command;

    RetryStatus(final Integer command) {
        this.command = command;
    }

    public static RetryStatus valueOfCommand(final Integer command) {
        return Arrays.stream(values())
                .filter(value -> value.command.equals(command))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer toCommand() {
        return this.command;
    }

    public boolean isKeepGoing() {
        return this == KEEP_GOING;
    }
}
