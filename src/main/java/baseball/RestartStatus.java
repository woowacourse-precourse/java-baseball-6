package baseball;

public enum RestartStatus {
    RESTART("1"),
    EXIT("2");

    private final String value;

    RestartStatus(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
