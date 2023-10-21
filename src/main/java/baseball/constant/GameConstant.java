package baseball.constant;

/**
 * {@summary 게임을 진행하는 데 필요한 상수들을 다룬다.}
 */
public enum GameConstant {
    MIN_BALL_NUM(1),
    MAX_BALL_NUM(9),
    TOTAL_BALL_CNT(3),
    THREE_STRIKE(3),
    RESTART(1),
    QUIT(2);

    private final int value;

    GameConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
