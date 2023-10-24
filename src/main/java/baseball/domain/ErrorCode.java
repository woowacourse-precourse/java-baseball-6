package baseball.domain;

public enum ErrorCode {

    NOT_SINGLE_NUMBER("1-9 사이의 숫자를 입력해 주세요."),
    ;

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
