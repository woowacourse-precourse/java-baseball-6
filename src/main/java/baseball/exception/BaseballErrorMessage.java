package baseball.exception;

public enum BaseballErrorMessage {
    INVALID_NUMBER_LENGTH("숫자는 %d자리여야 합니다."),
    INVALID_NUMBER_RANGE("%d ~ %d 사이의 숫자여야 합니다."),
    DUPLICATED_NUMBER("서로 다른 숫자여야 합니다."),
    INVALID_RESTART_NUMBER("재시작(1)/종료(2) 입력은 1 또는 2만 가능합니다."),
    NULL_OR_BLANK_INPUT("입력한 값이 null 혹은 빈값입니다.");

    private final String message;

    BaseballErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... numbers) {
        return String.format(message, numbers);
    }
}
