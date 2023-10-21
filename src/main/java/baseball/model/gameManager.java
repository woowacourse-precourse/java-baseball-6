package baseball.model;

public class gameManager {
    private String gameMode;

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        if(validateGameNumber(gameMode)) {
            this.gameMode = gameMode;
        }
    }

    public boolean validateGameNumber(String gameMode) {
        if(gameMode.equals("1") || gameMode.equals("2")) {
            return true;
        } else {
            throw new IllegalArgumentException("1과 2 중에서 선택해야합니다.");
        }
    }
}
