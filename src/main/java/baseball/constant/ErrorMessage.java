package baseball.constant;

public enum ErrorMessage {
    BLANK_INPUT("Error: 빈 문자열 입력"),
    CONTAIN_WHITE_SPACE_IN_INPUT("Error: 입력에 공백 포함"),
    CONTAIN_NO_NUMBER_IN_INPUT("Error: 숫자가 아닌 값 입력"),
    INVALID_DIGITS_IN_INPUT("Error: 자리 수 다르게 입력, %d 자리 수 숫자 입력 부탁드립니다"),
    CONTAIN_DUPLICATE_NUMBER_IN_INPUT("Error: 중복된 숫자 입력"),
    INVALID_CONTINUE_FLAG("Error: %d or %d 만 입력 가능합니다."),
    INVALID_DIGITS_AT_MAKING_NUMBERS("Error: numbers가 정해진 길이가 아닙니다, %d 길이의 numbers 부탁 드립니다."),
    DUPLICATE_NUMBER_AT_MAKING_NUMBERS("Error: numbers에 중복된 숫자가 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
