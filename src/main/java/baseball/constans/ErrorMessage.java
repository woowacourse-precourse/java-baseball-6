package baseball.constans;

public enum ErrorMessage {
    NUMBER_RANGE_EXCEPTION("[ERROR] 1~9 까지의 숫자만 입력 가능합니다."),
    NUMBER_LENGTH_EXCEPTION("[ERROR] 3자리 수만 입력 가능합니다."),
    NUMBER_NOT_CORRECT_EXCEPTION("[ERROR] 1 또는 2 의 값만 입력 가능합니다."),
    NUMBER_DUPLICATED_EXCEPTION("[ERROR] 같은 숫자는 1번만 입력 가능합니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
