package baseball.exception;

public enum ErrorMessage {
    ERROR_CAPTION("[ERROR] "),
    INVALID_USER_NUMBER_INPUT_FORMAT("숫자를 입력해 주세요."),
    INVALID_USER_NUMBER_CONTAINS_ZERO("0이 아닌 숫자 3개를 입력해주세요."),
    DUPLICATED_USER_NUMBER("서로 다른 숫자 3개를 입력해주세요."),
    INVALID_PLAY_AGAIN("1 또는 2를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_CAPTION.message + message;
    }
}
