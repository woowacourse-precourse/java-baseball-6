package baseball.message;

public enum ErrorMessage {
    DUPLICATE_NUMBER("서로 다른 정수를 입력해야 합니다."),
    ZERO_NUMBER("1과 9사이의 정수만 입력하세요."),
    NOT_INTEGER("숫자는 정수이어야 합니다."),
    DIFFERENT_LENGTHS("숫자의 개수는 3개이어야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
