package refactor.exception;

public enum ErrorCode {

    NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    NOT_SIZE("숫자가 3자리가 아닙니다."),
    ONE_TO_NINE("숫자에 0이 포함되었습니다."),
    ONE_TO_TWO("1 또는 2를 입력하지 않았습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
