package baseball.model;

public enum GameRestartOption {
    RESTART("1"),
    QUIT("2");

    private final String value;

    GameRestartOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}