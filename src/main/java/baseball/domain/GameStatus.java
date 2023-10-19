package baseball.domain;

public enum GameStatus {
    RESTART(1), EXIT(2);

    private static final String INVALID_GAME_STATUS_MESSAGE = "1 또는 2를 입력해주세요";
    private final int command;

    GameStatus(int command) {
        this.command = command;
    }

    public static GameStatus from(int command) {
        for (GameStatus gameStatus : GameStatus.values()) {
            if (gameStatus.command == command) {
                return gameStatus;
            }
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS_MESSAGE);
    }
}
