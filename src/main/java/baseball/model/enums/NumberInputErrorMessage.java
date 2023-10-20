package baseball.model.enums;

public enum NumberInputErrorMessage {
    INVALID_LENGTH("입력이 3자리가 아닙니다."),
    INVALID_CHARACTER("숫자가 아닌 문자가 입력되었습니다."),
    DUPLICATE_NUMBER("중복된 숫자가 입력되었습니다.");

    private String message;

    NumberInputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
