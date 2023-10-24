package baseball.constants;

public enum ErrorCode {
    INVALID_INPUT("입력된 수가 1-9 사이의 값이 아니거나 중복된 값이 있습니다."),
    INVALID_SIZE("정수는 총 3개 입력할 수 있습니다."),
    NOT_NUMERIC("입력한 값이 정수가 아닙니다."),
    INVALID_COMMAND("커맨드는 1 또는 2여야 합니다."),
    NOT_SUPPORTED_OPERATION("of()는 STRIKE와 BALL에서만 작동합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
