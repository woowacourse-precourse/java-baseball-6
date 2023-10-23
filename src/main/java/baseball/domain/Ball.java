package baseball.domain;

public record Ball(Integer number) {

    public static final int BALL_SIZE = 3;
    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;

    public boolean isSameNumber(Ball ball) {
        return this.number.equals(ball.number);
    }
}
