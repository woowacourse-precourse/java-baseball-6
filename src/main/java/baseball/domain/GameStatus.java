package baseball.domain;

public enum GameStatus {

    CONTINUE(100),
    BREAK(101),
    RESTART(1),
    EXIT(2);

    private final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static GameStatus fromValue(int value) {
        for (GameStatus status : values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("유효하지 않은 게임 상태 값입니다: " + value);
    }
}
