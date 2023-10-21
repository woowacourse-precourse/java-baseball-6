package baseball.exception;

public enum ErrorMessage {
    INPUT_LENGTH_IS_NOT_THREE("3자리 수를 입력해야합니다."),
    INPUT_DIGIT_IS_NOT_UNIQUE("3자리의 수가 모두 달라야 합니다."),
    INPUT_IS_NOT_DIGIT("1 이상 9 이하의 숫자가 아닙니다."),

    FINISH_INPUT_IS_WRONG("1 또는 2를 입력해야합니다."),

    ;

    public final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
