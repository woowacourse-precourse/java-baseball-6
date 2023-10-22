package baseball.utils;

public enum ErrorCode {

    GUESS_NUMBER_DUPLICATED("입력한 추측 값에 중복된 숫자가 있습니다."),
    GUESS_NUMBER_IS_NOT_THREE_LENGTH("입력한 추측 값의 길이가 3이 아닙니다."),
    GUESS_NUMBER_IS_NOT_DIGIT("입력한 추측 값이 숫자가 아닙니다."),
    RESTART_NUMBER_IS_NOT_VALID("재시작 입력 값이 유효하지 않습니다."),
    ;

    private final String errorMessage;

    ErrorCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
