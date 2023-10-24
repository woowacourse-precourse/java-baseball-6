package baseball.model;

import baseball.util.ExceptionMessage;

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
        throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_STATUS.getMessage());
    }

    public static GameStatus fromSelectedRetry(boolean selectedRetry) {
        if (selectedRetry) {
            return GAME_RETRY;
        }
        if (!selectedRetry) {
            return APPLICATION_EXIT;
        }
        throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_STATUS.getMessage());
    }

    public static boolean isApplicationExit(GameStatus gameStatus) {
        return gameStatus == GameStatus.APPLICATION_EXIT;
    }

    public static boolean isGameOver(GameStatus gameStatus) {
        return gameStatus == GameStatus.GAME_OVER;
    }
}
