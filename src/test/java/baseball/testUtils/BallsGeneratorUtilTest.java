package baseball.testUtils;

import baseball.balls.Ball;
import baseball.balls.Balls;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallsGeneratorUtilTest {

    @ParameterizedTest
    @MethodSource("BallListTestData")
    void BallsGeneratorUtil_동작(int ballCount, int minValue, boolean willDuplicateValue, boolean willDuplicateIndex,
            List<Ball> expectedBalls) {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(ballCount, minValue, willDuplicateValue,
                willDuplicateIndex);

        // then
        IntStream.range(0, ballCount)
                        .forEach(i -> {
                            Ball ball = balls.get(i);
                            Ball expectedBall = expectedBalls.get(i);
                            Assertions.assertEquals(ball, expectedBall);
                        });
    }

    static Stream<Arguments> BallListTestData() {
        return Stream.of(
                Arguments.of(2, 2, false, false, Arrays.asList(
                        new Ball(2, 0),
                        new Ball(3, 1)
                )),
                Arguments.of(3, 1, false, false, Arrays.asList(
                        new Ball(1, 0),
                        new Ball(2, 1),
                        new Ball(3, 2)
                )),
                Arguments.of(3, 1, true, false, Arrays.asList(
                        new Ball(1, 0),
                        new Ball(1, 1),
                        new Ball(1, 2)
                )),
                Arguments.of(3, 1, false, true, Arrays.asList(
                        new Ball(1, 0),
                        new Ball(2, 0),
                        new Ball(3, 0)
                ))
        );
    }

}
