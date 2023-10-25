package baseball.common;

public enum ErrorMessage {

    // InputView 메시지
    DUPLICATE_NUMBER("중복된 숫자가 있습니다"),
    NOT_APPROPRIATE_NUMBER("올바른 숫자가 아닙니다"),
    NOT_APPROPRIATE_LENGTH("길이가 너무 짧습니다!"),

    // RestartCalculator 메시지
    NOT_APPROPRIATE_RESTART_NUMBER("적절한 숫자가 아닙니다!");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
