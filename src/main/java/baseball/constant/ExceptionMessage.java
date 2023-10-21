package baseball.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자만 입력할 수 있습니다."),
    INVALID_LENGTH("3개의 숫자를 입력해주세요."),
    DUPLICATE_NUMBER("중복된 숫자는 입력할 수 없습니다.");

    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
