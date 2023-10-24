package baseball.domain;

public enum Ball {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private static final String BALL_RANGE_EXCEPTION_MESSAGE = "볼의 유효 범위는 0~3 입니다.";
    public static final String EMPTY = "";
    public static final String BALL_MESSAGE = "볼";
    private final int count;

    Ball(int ball) {
        this.count = ball;
    }

    public static Ball from(int count) {
        for (Ball ball : values()) {
            if (ball.count == count) {
                return ball;
            }
        }
        throw new IllegalArgumentException(BALL_RANGE_EXCEPTION_MESSAGE);
    }

    public boolean isEmpty() {
        return Ball.ZERO.equals(this);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return EMPTY;
        }
        return this.count + BALL_MESSAGE;
    }
}
