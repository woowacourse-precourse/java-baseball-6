package baseball.exception;

public enum ExceptionMessage {
    NOT_NUMERIC("%s는 숫자가 아닌 문자입니다."),
    NOT_UNIQUE("%s에 중복된 숫자가 존재합니다."),
    OUT_OF_RANGE("%d은 범위를 벗어난 숫자입니다."),
    OUT_OF_LENGTH("길이 %d으로 입력해야 합니다. 현재 길이: %d");

    private final String error;

    ExceptionMessage(String error) {
        this.error = error;
    }

    public String getError(Object... details) {
        return String.format(error, details);
    }
}