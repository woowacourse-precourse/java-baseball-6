package baseball.global.exception;

public enum ErrorMessage {
    INVALID_LENGTH("The input length cannot be different from length configured by the game."),
    DUPLICATED_NUMBER("The input cannot contain duplicated numbers."),
    CONTAIN_LETTER("The input cannot contain letters."),
    EMPTY_NUMBER("The input cannot be empty."),
    INVALID_FLAG("The input cannot be different flag from configured by the game."),
    SYSTEM_ERROR("The game system has crashed");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
