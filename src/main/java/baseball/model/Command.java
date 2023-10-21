package baseball.model;

public enum Command {

    RESTART("1"),
    EXIT("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }
}
