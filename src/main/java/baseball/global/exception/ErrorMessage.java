package baseball.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NOT_NUMBER_ERROR("숫자만을 입력해주세요."),
    INVALID_NUMBER_ERROR("숫자를 다시 입력해주세요."),
    INVALID_RANGE_ERROR("올바른 범위의 숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
