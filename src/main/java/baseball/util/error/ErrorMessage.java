package baseball.util.error;

public enum ErrorMessage {
    WRONG_DECISION("[ERROR] 1 또는 2를 선택해주세요.");

    private final String errorMessage;
    private ErrorMessage(final String message) {
        this.errorMessage = message;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
