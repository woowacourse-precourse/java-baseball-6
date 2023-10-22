package baseball.domain;

public enum GameState {
    RESTART, END;

    public static GameState of(boolean isRestart) {
        return isRestart? RESTART : END;
    }
}
