package baseball.model;

public enum GameStatus {
    APPLICATION_START,
    CREATE_PLAYER_NUMBER,
    GAME_OVER,
    APPLICATION_EXIT;

    public static GameStatus findGameState(boolean isThreeStrike, boolean selectedRetry) {
        if (isThreeStrike && !selectedRetry) {
            return APPLICATION_EXIT;
        }
        if (!isThreeStrike) {
            return CREATE_PLAYER_NUMBER;
        }
        if (isThreeStrike && selectedRetry) {
            return CREATE_PLAYER_NUMBER;
        }
        throw new IllegalArgumentException("해당하는 게임 상태가 없습니다.");
    }

}
