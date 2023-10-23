package baseball.util;

public enum ExceptionMessage {
    NOT_IN_RANGE("1부터 9까지 숫자만 입력 가능합니다."),
    INVALID_LENGTH("세자리 숫자만 입력 가능합니다."),
    DUPLICATED_NUMBER("입력값에 중복이 발생했습니다."),
    INVALID_OPTION("재시작, 종료를 위해 1 또는 2만 입력 가능합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
