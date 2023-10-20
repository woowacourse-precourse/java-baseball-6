package baseball.controller;

public enum Menu {
    CONTINUE("1"),
    DONE("2");

    private final String value;

    Menu(final String value) {
        this.value = value;
    }

    public static boolean restart(final String value) {
        return CONTINUE.value.equals(value);
    }
}
