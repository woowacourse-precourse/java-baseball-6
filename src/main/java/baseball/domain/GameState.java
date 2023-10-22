package baseball.model;

import baseball.utils.ErrorMessages;

public enum GameState {
    RUNNING,
    DONE,
    RETRY,
    QUIT,
    ;

    public static GameState of(BaseballResult baseballResult) {
        return switch (baseballResult) {
            case ALL_STRIKE -> DONE;
            default -> RUNNING;
        };
    }

    public static GameState of(int input) {
        return switch (input) {
            case 1 -> RETRY;
            case 2 -> QUIT;
            default -> throw new IllegalArgumentException(ErrorMessages.NOT_INVALID_RETRY_INPUT);
        };
    }

    public Boolean isRunable() {
        return this == RUNNING || this == RETRY;
    }

    public Boolean isRunning() {
        return this == RUNNING;
    }

    public Boolean isRetry() {
        return this == RETRY;
    }
}
