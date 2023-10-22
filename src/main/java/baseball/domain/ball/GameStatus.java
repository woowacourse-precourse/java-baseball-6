package baseball.domain.ball;

public enum GameStatus {
    UNKNOWN("_"),
    REPLAY("1"),
    EXIT("2");

    private final String input;

    GameStatus(final String input) {
        this.input = input;
    }

    public static GameStatus of(final String input) {
        if ("1".equals(input)) {
            return REPLAY;
        }
        if ("2".equals(input)) {
            return EXIT;
        }
        return UNKNOWN;
    }
}
