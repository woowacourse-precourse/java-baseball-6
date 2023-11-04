package baseball.enums;

public enum ExceptionMessage {
    WRONG_INPUT_DEFAULT("잘못된 입력입니다."),
    WRONG_INPUT_NOT_THREE_DIGITS("3자리만 입력 할 수 있습니다."),
    WRONG_INPUT_NOT_VALID_VALUE("유효한 값(숫자)이 아닙니다."),
    WRONG_INPUT_DUPLICATE_VALUE("숫자가 중복되어 있습니다.");
    String message;

    ExceptionMessage(String message) {
        this.message = message;
    }
}
