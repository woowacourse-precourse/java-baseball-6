package baseball;

import static baseball.NumericRange.COUNT;

public enum ErrorMessage {

    INVALID_SIZE(String.format("사이즈의 크기는 %d 이어야 합니다.", COUNT.getNumber())),
    DUPLICATED_NUMBER("중복되는 숫자가 있어선 안 됩니다."),
    NOT_NUMBER("숫자만 입력 가능합니다."),
    INVALID_INPUT("유효하지 않은 입력입니다.");

    private String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
