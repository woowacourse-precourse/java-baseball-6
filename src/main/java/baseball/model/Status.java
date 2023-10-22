package baseball.model;

import java.util.Arrays;

public enum Status {
    REPLAY(1),
    STOP(2),
    ;

    private final int status;

    Status(int status) {
        this.status = status;
    }

    public static Status from(int status) {
        return Arrays.stream(Status.values())
                .filter(s -> s.status == status)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("숫자 1 또는 2를 입력해주세요."));
    }
}
