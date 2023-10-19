package baseball.exception;

public enum ExceptionMessage {
    INVALID_INPUT_CHAR_ERROR("숫자만 입력해 주세요."),
    INVALID_INPUT_LENGTH_ERROR("3자리의 숫자만 입력해 주세요."),
    INVALID_DUPLICATE_NUMBER_ERROR("서로 다른 3자리의 숫자를 입력해 주세요."),
    INVALID_RANGE_OUT_NUMBER_ERROR("1 ~ 9 까지의 숫자만 입력해 주세요."),
    INVALID_END_INPUT_NUMBER_ERROR("1 또는 2의 숫자만 입력 해주세요.");


    private final String errorMsg;

    ExceptionMessage(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
