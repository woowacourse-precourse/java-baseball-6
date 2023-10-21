package baseball.utils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import baseball.utils.BallsUtils;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsUtilsTest {

    @Test
    void convertIntegersToBallList_성공() {
        // given
        List<Integer> integers = IntStream.rangeClosed(1, Balls.BALL_COUNT)
                .boxed()
                .toList();

        // when
        List<Ball> balls = BallsUtils.convertIntegersToBallList(integers);

        // then
        IntStream.range(0, Balls.BALL_COUNT)
                .forEach(i -> {
                    Ball ball = balls.get(i);
                    int expectedValue = i + 1;
                    int expectedIndex = i;
                    Ball expectedBall = new Ball(expectedValue, expectedIndex);
                    Assertions.assertTrue(ball.equals(expectedBall));
                });
    }
}
