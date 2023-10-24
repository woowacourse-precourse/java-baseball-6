package baseball;

public class Ball {

    private final int ball;
    private final int position;

    private static final int MIN_BALL = 1;

    private static final int MAX_BALL = 9;

    public Ball(int ball, int position) {
        this.ball = limitCheck(ball);
        this.position = position;
    }

    private int limitCheck(int ball) {
        if (ball > MAX_BALL || ball < MIN_BALL) {
            throw new IllegalArgumentException("1~9 사이의 숫자를 입력해 주세요.");
        }
        return ball;
    }

    public BallResultEnum play(Ball userBall) {
        if (this.equals(userBall)) {
            return BallResultEnum.STRIKE;
        }

        if (userBall.ball == this.ball) {
            return BallResultEnum.BALL;
        }
        return BallResultEnum.NOTHING;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball1 = (Ball) o;
        return ball == ball1.ball && position == ball1.position;
    }
}
