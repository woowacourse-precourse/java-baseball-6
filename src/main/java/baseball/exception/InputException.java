package baseball.exception;

public enum InputException {
    NOT_INTEGER("숫자가 아닌 값이 입력되었습니다."),
    MISMATCH_COUNT("세 개의 숫자를 입력해야 합니다."),
    DUPLICATE_NUM("중복된 숫자를 입력하였습니다."),
    INVALID_DECISION_NUM("1 또는 2를 입력하여야 합니다.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
