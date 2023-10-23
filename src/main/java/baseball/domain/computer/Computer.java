package baseball.domain.computer;

import baseball.domain.ball.Ball;
import baseball.domain.ball.Balls;
import baseball.domain.result.Result;
import baseball.domain.role.BallPicker;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final Balls balls;

    private Computer(Balls balls) {
        this.balls = balls;
    }

    public static Computer generate(BallPicker ballPicker, int rounds, int minValues, int maxValues) throws IllegalAccessException {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size() < rounds) {
            int randomBall = ballPicker.pickNumberInRange(minValues, maxValues);
            Ball ball = new Ball(randomBall, minValues, maxValues);

            ballList.add(ball);
        }

        return new Computer(new Balls(ballList, rounds));
    }

    public Result compare(Balls userBalls) {
        return userBalls.compare(this.balls);
    }
}
