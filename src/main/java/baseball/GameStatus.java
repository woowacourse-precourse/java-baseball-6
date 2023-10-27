package baseball;

public class GameStatus {
    public static final int GAME_SUCCESS_STATUS = 0;
    public static final int GAME_PROGRESS_STATUS = 1;
    public static final int GAME_END_STATUS = 2;

    private int gameSwitch;

    public GameStatus(int gameSwitch) {
        this.gameSwitch = gameSwitch;
    }

    public void checkGameSuccess(int strike) {
        if (strike == 3) {
            gameSwitch = GAME_SUCCESS_STATUS;
        }
    }

    public void checkGameStatusDecision(int gameStatusDecision) {
        if (gameStatusDecision == GAME_PROGRESS_STATUS) {
            gameSwitch = GAME_PROGRESS_STATUS;
        }
        if (gameStatusDecision == GAME_END_STATUS) {
            gameSwitch = GAME_END_STATUS;
        }
    }

    public boolean isGameSuccessStatus() {
        return gameSwitch == GAME_SUCCESS_STATUS;
    }

    public boolean isEndStatus() {
        return gameSwitch == GAME_END_STATUS;
    }
}