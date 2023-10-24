package baseball.util.validator;

public enum ValidateMessage {
    DUPLICATE_ERROR("[ERROR] 중복된 숫자를 입력 하지 마세요."),
    ZERO_NUMBER_INPUT_ERROR("[ERROR] 0은 올바른 숫자 야구 숫자가 아닙니다."),
    NOT_CORRECT_INPUT_SIZE("[ERROR] 세 자리 숫자를 입력 해주세요."),
    WRONG_INPUT("[ERROR] 숫자만 입력해주세요");

    private final String errorMessage;
    private ValidateMessage(final String message) {
        this.errorMessage = message;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
