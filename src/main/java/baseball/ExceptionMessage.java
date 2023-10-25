package baseball;

public enum ExceptionMessage {
    INVALID_ANSWER_LENGTH_MESSAGE("[ERROR] 입력값의 길이는 3이어야 합니다."),
    INVALID_ANSWER_RANGE_MESSAGE("[ERROR] 1부터 9까지의 숫자만을 입력해야 합니다."),
    INVALID_ANSWER_DUPLICATE_MESSAGE("[ERROR] 중복되지 않은 숫자들로 구성해야 합니다."),
    INVALID_RETRY_INPUT_LENGTH_MESSAGE("[ERROR] 입력값의 길이는 1이어야 합니다."),
    INVALID_RETRY_INPUT_RANGE_MESSAGE("[ERROR] 1 혹은 2를 입력해야 합니다.");
    private String message;

    ExceptionMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return (message);
    }
}
