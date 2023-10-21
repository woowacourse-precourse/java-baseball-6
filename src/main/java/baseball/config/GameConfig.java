package baseball.config;

public enum GameConfig {
    GAME_RESTART_FLAG("2");

    private final String value;

    GameConfig(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
