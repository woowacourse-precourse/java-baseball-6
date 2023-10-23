package baseball.util;

public enum ExceptionMessage {
    NOT_NUMERIC("입력 범위를 초과했습니다."),
    NOT_IN_RANGE("1부터 9까지의 숫자만 입력 가능합니다."),
    INVALID_LENGTH("세 자리 자연수를 입력해 주세요.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
