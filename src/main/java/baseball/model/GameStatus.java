package baseball.model;

public enum GameStatus {
    GAME_START,
    CREATE_PLAYER_NUMBER,
    GAME_OVER,
    GAME_RETRY,
    APPLICATION_EXIT;

    public static GameStatus fromIsThreeStrike(boolean isThreeStrike) {
        if (isThreeStrike) {
            return GAME_OVER;
        }
        if (!isThreeStrike) {
            return CREATE_PLAYER_NUMBER;
        }
        throw new IllegalArgumentException("해당하는 게임 상태가 없습니다.");
    }

    public static GameStatus fromSelectedRetry(boolean selectedRetry) {
        if (selectedRetry) {
            return GAME_RETRY;
        }
        if (!selectedRetry) {
            return APPLICATION_EXIT;
        }
        throw new IllegalArgumentException("해당하는 게임 상태가 없습니다.");
    }

}
