package baseball.model;

public final class Ball {
    private final int index;
    private final BallNumber number;

    private Ball(int index, BallNumber number) {
        this.index = index;
        this.number = number;
    }
    public static Ball of(int comIndex, BallNumber comNumber) {
        return new Ball(comIndex, comNumber);
    }

    public BallStatus compute(Ball user) {
        if (this.number.equals(user.number) && this.index == user.index) {
            return BallStatus.STRIKE;
        }
        if (this.number.equals(user.number)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
