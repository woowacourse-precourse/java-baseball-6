package baseball.Model;

public enum GameState {
    GAME_START,
    GAME_OVER,
    GAME_ING,
    GAME_END;

    public static GameState gameOver(boolean threeStrike) {
        if (!threeStrike) {
            return GAME_ING;
        }
        return GAME_OVER;
    }

    public static GameState gameRestart(boolean restart) {
        if (restart) {
            return GAME_ING;
        }
        return GAME_END;
    }

}
