package baseball.exception;

public enum ErrorMessage {
    INVALID_INPUT_NUMBER("양의 정수를 입력해주세요."),
    INVALID_COMMAND("1 또는 2를 입력하세요."),
    DUPLICATED_NUMBERS("중복되지 않은 숫자를 입력하세요."),
    INVALID_LENGTH("3자리 숫자를 입력하세요."),
    INVALID_RANGE("1 ~ 9 사이의 숫자를 입력하세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
