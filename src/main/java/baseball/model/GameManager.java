package baseball.model;

public class GameManager {

    private GameMode gameMode;

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setPlayMode(String mode) {
        this.gameMode = GameMode.of(mode);
    }

    public boolean isEndMode() {
        return this.gameMode == GameMode.END;
    }

    public void setEndMode() {
        this.gameMode = GameMode.END;
    }
}