package baseball.ball;

import baseball.game.GameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    public static final int INIT = 0;
    public static final int BALLS_SIZE = 3;
    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (int i = INIT; i < BALLS_SIZE; i++) {
            Number number = new Number(numbers.get(i));
            Index index = new Index(i);
            Ball ball = new Ball(number, index);
            balls.add(ball);
        }

        this.balls = Collections.unmodifiableList(balls);
    }

    public GameResult compareWithBalls(Balls otherBalls) {
        GameResult gameResult = new GameResult();

        for(Ball ball : this.balls) {
            Result result = otherBalls.compareWithBall(ball);
            gameResult.plusScore(result);
        }

        return gameResult;
    }

    public Result compareWithBall(Ball otherBall) {
        for (Ball ball : this.balls) {
            Result result = ball.compareWithOtherBall(otherBall);

            if (result.isNotNothing()) {
                return result;
            }
        }

        return Result.NOTHING;
    }
}
