package baseball.enums;

public enum ErrorCode {
    WRONG_LENGTH("숫자의 길이가 3이 아닙니다."),
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    OUT_OF_RANGE("1~9 사이의 숫자가 아닙니다."),
    INVALID_CONTINUATION_INPUT("재시작/종료를 구분하는 1 또는 2의 숫자가 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
