package baseball.exception;

public enum ErrorMessage {
    CAPTION("[ERROR] "),
    NOT_REQUIRED_RANGE("1에서 9까지만 입력할 수 있습니다."),
    DUPLICATED_VALUE("중복되는 숫자는 입력할 수 없습니다."),
    NONE_NUMERIC("숫자 이외에는 입력할 수 없습니다."),
    EMPTY_VALUE("공백은 입력할 수 없습니다"),
    NOT_REQUIRED_SIZE("세 자리 이외에는 입력할 수 없습니다."),
    NOT_REQUIRED_RESTART_INPUT("1과 2 이외에는 입력할 수 없습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
