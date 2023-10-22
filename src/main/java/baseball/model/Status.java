package baseball.model;

import static baseball.model.message.ErrorMessage.INVALID_REPLAY_STATUS;

import java.util.Arrays;

public enum Status {
    REPLAY("1"),
    STOP("2"),
    ;

    private final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status from(String status) {
        return Arrays.stream(Status.values())
                .filter(s -> s.status.equals(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_REPLAY_STATUS.getMessage()));
    }
}
