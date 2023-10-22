package baseball.model;

import baseball.utils.ErrorMessages;

public enum GameState {
    RUNNING,
    DONE,
    RETRY,
    QUIT,
    ;

    public GameState of(BaseballResult baseballResult) {
        return switch (baseballResult) {
            case ALL_STRIKE -> DONE;
            default -> RUNNING;
        };
    }

    public GameState of(int input) {
        return switch (input) {
            case 1 -> RETRY;
            case 2 -> QUIT;
            default -> throw new IllegalArgumentException(ErrorMessages.NOT_INVALID_RETRY_INPUT);
        };
    }
}
