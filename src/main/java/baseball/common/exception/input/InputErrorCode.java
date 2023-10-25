package baseball.common.exception.input;

public enum InputErrorCode {
    INVALID_SIZE("세 자리가 아닙니다."),
    INVALID_DIGIT_RANGE("각 자리수는 1 ~ 9사이 숫자이여야 합니다."),
    NON_NUMERIC("숫자여야 합니다."),
    DUPLICATED("각 문자는 중복을 허용하지 않습니다."),
    INVALID_INPUT_VALUE("입력값은 필수입니다."),
    INVALID_CONTINUE_ANSWER("0과 1중 하나의 값을 입력해주세요.");

    String message;
    InputErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
