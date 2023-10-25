package baseball.constant;

public enum Command {
    RETRY_GAME("1"), END_GAME("2");

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public String getCommand() {
        return value;
    }
}
