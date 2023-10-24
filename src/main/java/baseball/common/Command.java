package baseball.common;

public enum Command {
    RESTART("1"),
    QUIT("2");

    private final String key;

    Command(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
