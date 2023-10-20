package baseball.domain;

public class Ball {
    public static final int BALL_SIZE = 3;
    public static final int MIN_BALL = 1;
    public static final int MAX_BALL = 9;
    private final Integer number;
    public Ball(Integer number) {
        this.number = number;
    }
    public Integer getNumber() {
        return number;
    }
}
