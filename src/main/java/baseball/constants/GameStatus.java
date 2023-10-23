package baseball.constants;

public enum GameStatus {
    REPLAY("1"),
    EXIT("2");

    private final String code;

    GameStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
