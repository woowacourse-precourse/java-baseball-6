package baseball.model;

public class GameManager {

    private GameMode gameMode;

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(String mode) {
        this.gameMode = GameMode.of(mode);
    }
}