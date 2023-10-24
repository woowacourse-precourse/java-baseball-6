package baseball.constants;

public enum SystemOption {
    RESTART_SYSTEM_VALUE("1"),
    EXIT_SYSTEM_VALUE("2");
    private String value;

    SystemOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
