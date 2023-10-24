package baseball.controller;

public enum InputCommand {

    EXIT_COMMAND("2"),
    RESTART_COMMAND("1");

    public String getValue() {
        return value;
    }

    private final String value;

    InputCommand(String value) {
        this.value = value;
    }
}
