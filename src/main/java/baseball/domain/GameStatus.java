package baseball.domain;

public enum GameStatus {
    CONTINUE(0),
    RESTART(1),
    END(2);

    private final int status;

    GameStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}