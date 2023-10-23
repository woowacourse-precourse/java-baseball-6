package baseball.model;

public class GameManager {

    private static final String GAME_MODE_CONTINUE = "1";
    private static final String GAME_MODE_END = "2";
    private String gameMode;

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        if(validateGameMode(gameMode)) {
            this.gameMode = gameMode;
        }
    }

    private boolean validateGameMode(String gameMode) {
        if(GAME_MODE_CONTINUE.equals(gameMode) || GAME_MODE_END.equals(gameMode)) {
            return true;
        } else {
            throw new IllegalArgumentException("1과 2 중에서 선택해야합니다.");
        }
    }
}