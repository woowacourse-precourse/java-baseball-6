package baseball.controller;

public enum Menu {
    CONTINUE("1"),
    DONE("2");

    Menu(String value) {
    }

    public static boolean restart(String value) {
        return valueOf(value) == CONTINUE;
    }
}
