package baseball.constants;

public enum ErrorMessage {
    INVALID_INPUT("유효하지 않은 입력입니다."),
    INVALID_RESTART_OR_EXIT("입력 값은 1 (재시작) 또는 2 (종료) 여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
