package baseball;

public enum InputValidateRegex {
    GAME_NUMBER_REGEX("^(?!.*(.).*\\1)\\d{3}$"),
    RETRY_INPUT_REGEX("^[12]+$");

    private final String regex;

    InputValidateRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String toString() {
        return this.regex;
    }
}
