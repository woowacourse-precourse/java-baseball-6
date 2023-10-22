package baseball.util;

public enum ExceptionMessage {
    NOT_NUMERIC("입력 범위를 초과했습니다."),
    CHECK_RETRY("입력 값을 다시 한번 확인해주세요.(1,2)"),
    NOT_DUPLICATE("숫자의 중복은 허용되지 않습니다."),
    CHECK_NUMBERS_LENGTH("3자리 수의 숫자를 입력해주세요"),
    NOT_ZERO("0은 입력할 수 없습니다."),
    ONLY_NUMBER("숫자만 입력해주세요");

    public static final String ERROR = "[ERROR] %s";
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format(ERROR, message);
    }

    public String getMessage() {
        return message;
    }
}
