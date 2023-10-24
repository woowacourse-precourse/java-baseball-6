package baseball.exception;

public enum ExceptionMessage {
    INVALID_LENGTH("입력 문자열 길이가 %d이 아닙니다."),
    MUST_BE_BETWEEN("입력 범위는 %d 이상 %d 이하만 가능합니다."),
    NOT_MUST_BE_DUPLICATE("입력 문자열 %s의 길이가 유효하지 않거나 중복이 있습니다."),
    MUST_BE_DIGIT("숫자만 입력 가능합니다.");

    public static final String BASE_MESSAGE = "[ERROR] %s";
    private final String message;

    ExceptionMessage(final String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String format(final Object... args) {
        return String.format(message, args);
    }
}
