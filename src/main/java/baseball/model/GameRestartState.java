package baseball.model;

public enum GameRestartState {
    RESTART("1"),
    GAME_OVER("2"),
    UNKNOWN("");

    final String flag;

    GameRestartState(String flag) {
        this.flag = flag;
    }

    public static GameRestartState findGameStateFromString(String flag) {
        return switch (flag) {
            case "1" -> RESTART;
            case "2" -> GAME_OVER;
            default -> UNKNOWN;
        };
    }
}
