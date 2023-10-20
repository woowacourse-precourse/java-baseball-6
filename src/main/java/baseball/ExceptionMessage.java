package baseball;

public enum ExceptionMessage {
    IS_NOT_DIGIT("1이상 9이하의 수를 입력해야 합니다."),
    IS_NOT_THREE("3개의 수를 입력해야 합니다."),
    HAS_DUPLICATE("3개의 수는 중복이 없어야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
