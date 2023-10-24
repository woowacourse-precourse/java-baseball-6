package baseball.domain.game;

public enum GameStatus {
    RUN,
    STOP;

    public static boolean isRun(GameStatus gameStatus) {
        return gameStatus == GameStatus.RUN;
    }
}
