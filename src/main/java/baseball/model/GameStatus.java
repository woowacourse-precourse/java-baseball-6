package baseball.model;

public enum GameStatus {
    GAME_START,
    CREATE_PLAYER_NUMBER,
    GAME_OVER,
    APPLICATION_EXIT;

    public static GameStatus findGameStatus(boolean isThreeStrike, boolean selectedRetry) {
        if (isThreeStrike && !selectedRetry) {
            return APPLICATION_EXIT;
        }
        if (!isThreeStrike) {
            return CREATE_PLAYER_NUMBER;
        }
        if (isThreeStrike && selectedRetry) {
            return GAME_START;
        }
        throw new IllegalArgumentException("해당하는 게임 상태가 없습니다.");
    }

}
