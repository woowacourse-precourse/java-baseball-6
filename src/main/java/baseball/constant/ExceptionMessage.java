package baseball.constant;

public enum ExceptionMessage {

    REQUIRES_3_DIGITS("세자리 숫자를 입력해주세요"),
    REQUIRES_1_DIGIT("한자리 숫자를 입력해주세요"),
    REQUIRES_UNIQUE_ELEMENTS("중복되지 않은 세자리 숫자를 입력해주세요"),
    REQUIRES_1_BETWEEN_9("1과 9 사이의 숫자만을 입력해주세요"),
    REQUIRES_1_OR_2("1 또는 2 중에서만 선택해주세요");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}