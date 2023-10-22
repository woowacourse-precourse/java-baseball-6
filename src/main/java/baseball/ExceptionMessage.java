package baseball;

public enum ExceptionMessage {
    OUT_OF_ONE_TO_NIME("[ERROR] 1 ~ 9 사이의 값만 입력해주세요"),
    OUT_OF_NUMBER_RANGE("[ERROR] %d자리 숫자를 입력하셔야 합니다"),
    HAVE_DUPLICATE_NUMBER("[ERROR] 중복된 값이 있습니다."),
    NOT_AVAILABLE_STRING("[ERROR] 숫자만 입력해주세요."),
    ;

    private final String message;

    private ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
