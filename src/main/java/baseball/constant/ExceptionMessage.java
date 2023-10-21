package baseball.constant;

public enum ExceptionMessage {

    NOT_INTEGER("숫자만 입력할 수 있습니다.");

    private final String message;


    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
