package baseball.domain;

public enum GameProcessStatus {
    GAME_RUNNING,
    GAME_RESTART,
    GAME_TERMINATE,
    ;

    public boolean isGameInProgress() {
        return this != GAME_TERMINATE;
    }
}
