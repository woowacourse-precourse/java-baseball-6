package baseball.controller;

public enum GameCommand {
    RESTART("1"),
    END("2");

    private final String String;

    GameCommand(java.lang.String string) {
        String = string;
    }

    public String getString() {
        return String;
    }
}
