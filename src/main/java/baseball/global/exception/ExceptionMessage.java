package baseball.global.exception;

public enum ExceptionMessage {
    INPUT_CANNOT_BE_NULL("입력값으로 null은 안 됩니다")
    ,INPUT_MUST_BE_THREE_DIGIT_NUMBERS("숫자 3자리로 입력하세요")
    ,INPUT_MUST_BE_THREE_DIFFERENT_NUMBERS("숫자는 서로 다른 세자리 수 입력")

    ,INPUT_MUST_BE_ONE_OR_TWO("1 혹은 2의 숫자만 입력 가능")
    ;

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
