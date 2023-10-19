package baseball.common;

public enum Command {
    RESTART(1),
    QUIT(2);

    private final int key;

    Command(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
