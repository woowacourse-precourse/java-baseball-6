package baseball.exception;

public enum ErrorMessage {
    CANNOT_PARSE_INT("숫자로 변환할 수 없는 문자입니다."),
    INPUT_NUMBER_ERROR("입력 숫자는 세자리 수여야 합니다.");

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
