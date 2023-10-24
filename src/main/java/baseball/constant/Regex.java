package baseball.constant;

public enum Regex {
    ONE_OR_TWO("[12]"),
    ONE_TO_NINE("^[1-9]{3}$");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public boolean matches(String input) {
        return input.matches(regex);
    }
}

