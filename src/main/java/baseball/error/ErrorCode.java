package baseball.error;

public enum ErrorCode {

    RESTART_ERROR("Number must be 1 or 2"),
    DIGIT_ERROR("Number must be digit"),
    SIZE_ERROR("Number must be correct-digit size"),
    DUPLICATION_ERROR("Number must not be duplicated");

    public final String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
