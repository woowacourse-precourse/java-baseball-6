package baseball.domain;

public enum GameStatus {
    CONTINUE(0),
    RESTART(1),
    END(2);

    public static final String WRONG_INPUT_OPTION_EX_MESSAGE = "재시작은 1 또는 2를 입력해야 합니다. \n";

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
        throw new IllegalArgumentException(WRONG_INPUT_OPTION_EX_MESSAGE);
    }
}