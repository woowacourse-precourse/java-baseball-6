package baseball;

public enum GameState {
    START("1"),
    END("2"),
    ONGOING("3"),
    ;

    GameState(String key) {}

    public static GameState getByKey(String key) {
        return switch (key) {
            case "1" -> GameState.START;
            case "2" -> GameState.END;
            default -> throw new IllegalArgumentException();
        };
    }
}
