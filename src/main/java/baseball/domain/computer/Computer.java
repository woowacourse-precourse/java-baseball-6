package baseball.domain.computer;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import baseball.domain.picker.BallPicker;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static final int ROUNDS = 3;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 9;

    private final Balls balls;

    private Computer(Balls balls) {
        this.balls = balls;
    }

    public static Computer generate(BallPicker ballPicker){
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size() < ROUNDS) {
            Ball ball = ballPicker.pickNumberInRange(MIN_RANGE, MAX_RANGE);

            pickBall(ballList, ball);
        }

        return new Computer(new Balls(ballList));
    }

    private static void pickBall(List<Ball> ballList, Ball ball) {
        if (!ballList.contains(ball)) {
            ballList.add(ball);
        }
    }

    public Result compare(Balls userBalls) {
        return userBalls.compare(this.balls);
    }
}
