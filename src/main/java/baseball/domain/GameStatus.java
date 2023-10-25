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

    public static GameStatus fromInt(int input) {
        for (GameStatus status : GameStatus.values()) {
            if (status.getStatus() == input) {
                return status;
            }
        }
        return null;
    }
}