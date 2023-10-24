package baseball.enums;

public enum ErrorCode {
    WRONG_LENGTH("숫자의 길이가 3이 아닙니다."),
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),
    OUT_OF_RANGE("1~9 사이의 숫자가 아닙니다."),
    INVALID_GAME_CHOICE("지속 여부를 표시하는 1~2 사이의 숫자가 아닙니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
