package baseball.status;

public enum GameSetting {
    COUNT_NUM(3),
    MIN_NUM(1),
    MAX_NUM(9),
    REPLAY("1"),
    OVER("2"),
    INPUT_REGEX("^[1-9]$"),
    CHOICE_REGEX("^[1-2]$");

    private final int value;
    private final String stringValue;

    GameSetting(int value) {
        this.value = value;
        this.stringValue = null;
    }

    GameSetting(String stringValue) {
        this.value = -1;
        this.stringValue = stringValue;
    }

    public int getValue() {
        return this.value;
    }

    public String getStringValue() {
        return this.stringValue;
    }
}