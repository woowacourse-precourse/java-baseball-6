package baseball.status;

import java.util.Arrays;

public enum SystemStatus {
    NEW_GAME("1"),
    EXIT("2");

    private String code;

    SystemStatus(String code) {
        this.code = code;
    }

    public static SystemStatus of(String code) {
        return Arrays.stream(values())
                .filter(status -> status.code.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
