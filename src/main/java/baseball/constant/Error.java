package baseball.constant;

public enum Error {
    INPUT_ASK_RETRY("not normal input when check game retry!"),

    INPUT_USER_INPUT_NUMBER("wrong input string!"),

    NOT_VALID_SCORE("score is not valid!"),

    NUMBERS_SIZE("not valid number size error!");

    private final String value;

    Error(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }
}
