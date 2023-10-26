package baseball.model;

public record Ball(int positoin, BallNo ballNo) {

    public Ball(int postion, int ballNo) {
        this(postion, new BallNo(ballNo));
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) return BallStatus.STRIKE;

        if (ball.matchBallNo(this.ballNo)) return BallStatus.BALL;

        return BallStatus.NOTHING;
    }

    private boolean matchBallNo(BallNo number) {
        return this.ballNo.equals(number);
    }
}
