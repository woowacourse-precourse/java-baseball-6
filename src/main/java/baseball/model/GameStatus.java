package baseball.model;

import baseball.util.ExceptionMessage;
import baseball.util.GameStatusHelper;

public enum GameStatus {
    GAME_START {
        @Override
        public GameStatus fromIsThreeStrike(boolean isThreeStrike) {
            return GameStatusHelper.fromIsThreeStrike(isThreeStrike);
        }

        @Override
        public GameStatus fromSelectedRetry(boolean selectedRetry) {
            return GameStatusHelper.fromSelectedRetry(selectedRetry);
        }
    },
    CREATE_PLAYER_NUMBER,
    GAME_OVER,
    GAME_RETRY,
    APPLICATION_EXIT;

    public static boolean isApplicationExit(GameStatus gameStatus) {
        return gameStatus.equals(GameStatus.APPLICATION_EXIT);
    }

    public static boolean isGameOver(GameStatus gameStatus) {
        return gameStatus.equals(GameStatus.GAME_OVER);
    }

    public GameStatus fromIsThreeStrike(boolean isThreeStrike) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_STATUS.getMessage());
    }

    public GameStatus fromSelectedRetry(boolean selectedRetry) {
        throw new IllegalArgumentException(ExceptionMessage.INVALID_GAME_STATUS.getMessage());
    }
}