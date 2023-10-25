package baseball.constant;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해주세요."),
    INVALID_RETRY_COMMAND("재시작 입력값이 잘못되었습니다."),
    INVALID_BALL_COUNT_SIZE("볼카운트 개수가 잘못되었습니다."),
    INVALID_NUMBER_RANGE("숫자의 범위를 벗어났습니다."),
    INVALID_NUMBERS("숫자 목록이 잘못되었습니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
