package baseball.util;

import baseball.model.GameStatus;

public class GameStatusHelper {

    public static GameStatus fromIsThreeStrike(boolean isThreeStrike) {
        return isThreeStrike ? GameStatus.GAME_OVER : GameStatus.CREATE_PLAYER_NUMBER;
    }

    public static GameStatus fromSelectedRetry(boolean selectedRetry) {
        return selectedRetry ? GameStatus.GAME_RETRY : GameStatus.APPLICATION_EXIT;
    }

    public static boolean isApplicationExit(GameStatus gameStatus) {
        return gameStatus.equals(GameStatus.APPLICATION_EXIT);
    }

    public static boolean isGameOver(GameStatus gameStatus) {
        return gameStatus.equals(GameStatus.GAME_OVER);
    }
}