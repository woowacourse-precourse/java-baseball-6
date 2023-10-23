package baseball.constant;

public enum ExceptionMessage {
    OUT_OF_NUMBER_RANGE("%d ~ %d 사이의 값만 입력해주세요"),
    OUT_OF_NUMBER_DIGITS_RANGE("%d자리 숫자를 입력하셔야 합니다"),
    HAVE_DUPLICATE_NUMBER("중복된 값이 있습니다."),
    NOT_AVAILABLE_STRING("숫자만 입력해주세요."),
    ;

    private static final String ERROR = "[ERROR]";
    private final String message;

    private ExceptionMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }
}
