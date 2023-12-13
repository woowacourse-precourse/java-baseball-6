package baseball.domain;

import baseball.util.exception.IllegalArgumentExceptionType;
import java.util.Arrays;

public enum PlayStatus {
    RETRY("1"),
    END("2");

    private final String status;

    PlayStatus(String status) {
        this.status = status;
    }

    public static PlayStatus getPlayStatus(String userInput) {
        return Arrays.stream(PlayStatus.values())
                .filter(status -> userInput.equals(status.getStatus()))
                .findFirst()
                .orElseThrow(IllegalArgumentExceptionType.INVALID_INPUT::getException);
    }

    public String getStatus() {
        return status;
    }
}
