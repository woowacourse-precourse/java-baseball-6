package baseball.constant;

public enum ErrorMessage {

    INPUT_EMPTY("입력값은 비어있지 않아야 합니다."),
    INPUT_LENGTH_INVALID("입력값은 3자리이어야 합니다."),
    INPUT_NUMBER_NOT_INTEGER("입력값은 정수이어야 합니다."),
    INPUT_NUMBER_NOT_POSITIVE_INTEGER("입력값은 양의 정수이어야 합니다."),
    INPUT_NUMBER_NOT_IN_RANGE("입력되는 각 숫자는 1 이상 9 이하의 정수로 이루어져야 합니다."),
    INPUT_NUMBER_NOT_UNIQUE("입력되는 각 숫자는 서로 다른 숫자이어야 합니다.");


    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
