package baseball.constant;

public enum ErrorMessage {
    NUMBER_INPUT_ERROR("유효하지 않은 숫자 입력입니다."),
    RETRY_INPUT_ERROR("유효하지 않은 재시도 여부 입력입니다."),
    INVALID_INDEX_ERROR("유효하지 않은 인덱스입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
