package baseball.view;

public enum RegexPattern {
    ONLY_NUMBER("^[0-9]*$"),
    ONE_TO_NINE("[1-9]+");


    private final String value;

    RegexPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
