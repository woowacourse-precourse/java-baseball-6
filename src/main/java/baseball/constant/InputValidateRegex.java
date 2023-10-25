package baseball.constant;

public enum InputValidateRegex {
    GAME_NUMBER_REGEX("^(?!.*(.).*\\1)\\d{3}$"),
    GAME_DECISION_REGEX("^[12]+$");

    private final String regex;

    InputValidateRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
