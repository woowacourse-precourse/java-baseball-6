package baseball.exception;

public enum InputException {
    NOT_INTEGER("숫자가 아닌 값이 입력되었습니다.");

    private final String exceptionMessage;

    InputException(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return this.exceptionMessage;
    }
}
