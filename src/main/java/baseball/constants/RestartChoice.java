package baseball.constants;

public enum RestartChoice {
    RESTART("1"),
    QUIT("2");

    private final String value;

    RestartChoice(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isValidChoice(String input) {
        for (RestartChoice choice : values()) {
            if (choice.value.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public boolean matches(String input) {
        return this.value.equals(input);
    }
}