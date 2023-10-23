package baseball.domain.exception;

public enum ErrorMessage {
    INVALID_LENGTH("The input length cannot be different from length configured by the game."),
    DUPLICATED_NUMBER("The input cannot contain duplicated numbers."),
    CONTAIN_LETTER("The input cannot contain letters."),
    EMPTY_NUMBER("The input cannot be empty.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
