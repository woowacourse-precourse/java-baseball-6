package baseball.model;

public enum GameMode {
    PLAY("1"),
    END("2");

    private final String mode;

    GameMode(String mode) {
        this.mode = mode;
    }

    protected String getMode() {
        return this.mode;
    }

    public static GameMode of(String mode) {
        for (GameMode gameMode : values()) {
            if (gameMode.getMode().equals(mode)) {
                return gameMode;
            }
        }
        throw new IllegalArgumentException("Invalid game mode: " + mode);
    }
}
