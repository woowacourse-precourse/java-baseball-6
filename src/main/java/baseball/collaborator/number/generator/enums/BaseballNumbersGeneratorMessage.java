package baseball.collaborator.number.generator.enums;

public enum BaseballNumbersGeneratorMessage {

    REQUEST_ENTER_NUMBERS("숫자를 입력해주세요 : "),
    ALERT_THREE_DIGIT_NUMBER("야구숫자는 세 자리여야 합니다."),
    ALERT_DUPLICATE_INPUT_VALUES("입력값은 중복되지 않아야 합니다."),
    ALERT_NEGATIVE_NUMBER("음수는 입력할 수 없습니다."),
    ;

    private final String message;

    BaseballNumbersGeneratorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }

}
