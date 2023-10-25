package baseball.utils;

public enum ErrorCode {
    DUPLICATED_GUESS_NUM("입력값이 중복됩니다."),
    INVALID_GUESS_NUM_LENGTH("입력값의 길이가 유효하지 않습니다."),
    NON_DIGIT_GUSS_NUM("입력값이 숫자가 아닙니다."),
    INVALID_RESTART_NUM("재시작 값이 유효하지 않습니다.");

    private final String errorCode;

    ErrorCode(String errorcode) {
        this.errorCode = errorcode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
