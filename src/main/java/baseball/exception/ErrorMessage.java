package baseball.exception;

public enum ErrorMessage {

    INVALID_INPUT("올바르지 않은 입력잆니다."),
    INVALID_VALUD("올바르지 않은 값입니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
