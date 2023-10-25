package baseball.model;

public enum Command {
    RESTART("1"),
    FINISH("2");

    private final String command;

    Command(String command) {
        this.command = command;
    }

    public String getValue() {
        return command;
    }
}
