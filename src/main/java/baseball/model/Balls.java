package baseball.model;

import java.util.List;

public final class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }
    public static Balls of(List<Integer> numbers) {
        checkRange(numbers);
        List<Ball> newBalls = numbers.stream()
                .map(number -> Ball.of(numbers.indexOf(number), BallNumber.of(number)))
                .toList();
        return new Balls(newBalls);
    }

    private static void checkRange(List<Integer> numbers) {
        if (numbers.size() != 3) {
            System.out.println(numbers.size());
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }

    public Ground computeFromBallsToGround(Balls userBalls) {
        int strike = 0;
        int ball = 0;
        for (Ball tempBall : balls) {
            BallStatus ballStatus = userBalls.computeFromBallToBallStatus(tempBall);
            if (ballStatus.isStrike()) {
                strike++;
            }
            if (ballStatus.isBall()) {
                ball++;
            }
        }
        return Ground.of(strike, ball);
    }

    private BallStatus computeFromBallToBallStatus(Ball ball) {
        return balls.stream()
                .map(ball::compute)
                .filter(BallStatus::isNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
