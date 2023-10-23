package constant;

public enum ExceptionMessage {
    INVALID_INPUT("유효하지 않은 입력"),
    DUPLICATE_NUMBER_INPUT("중복된 수 입력"),
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
