package baseball;

public class Computer {
    private final Ball ball;

    public Computer() {
        this.ball = new Ball();
    }

    public BallResult getUserBallResult(Ball userBall) {
        return ball.compareWith(userBall);
    }

}


