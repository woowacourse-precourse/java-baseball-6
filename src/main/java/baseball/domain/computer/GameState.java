package baseball.domain.computer;

public enum GameState {
    RUNNING(0),
    RESTART(1),
    END(2),
            ;

    private final int command;

    GameState(int command) {
        this.command = command;
    }

    public static GameState init() {
        return GameState.RUNNING;
    }

    public boolean isEndGame() {
        return this == END;
    }
}
