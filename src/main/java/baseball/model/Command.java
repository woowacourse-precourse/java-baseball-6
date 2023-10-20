package baseball.model;

public enum Command {
    RESTART("1"),
    QUIT("2");

    final String value;

    Command(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


    @Override
    public String toString() {
        return this.value;
    }
}
