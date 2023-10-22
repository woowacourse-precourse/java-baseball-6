package baseball;

import java.util.List;

public final class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }
    public static Balls of(List<Integer> numbers) {
        List<Ball> newBalls = numbers.stream()
                .map(number -> Ball.of(numbers.indexOf(number), BallNumber.of(number)))
                .toList();
        return new Balls(newBalls);
    }

    public Ground compute(Balls userBalls) {
        int strike = 0;
        int ball = 0;
        for (Ball tempBall : balls) {
            BallStatus ballStatus = userBalls.compute(tempBall);
            if (ballStatus.isStrike()) {
                strike++;
            }
            if (ballStatus.isBall()) {
                ball++;
            }
        }
        return Ground.of(strike, ball);
    }

    private BallStatus compute(Ball ball) {
        return balls.stream()
                .map(ball::compute)
                .filter(BallStatus::isNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
