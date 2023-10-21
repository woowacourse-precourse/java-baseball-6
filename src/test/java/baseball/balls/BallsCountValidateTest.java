package baseball.balls;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsCountValidateTest {

    @Test
    void 공_개수_기준치_동일_허용() {
        // given
        int ballCount = Balls.BALL_COUNT;

        // when
        List<Ball> balls = generateBalls(ballCount);

        // then
        Assertions.assertDoesNotThrow(() -> {
            new Balls(balls);
        });
    }

    @Test
    void 공_개수_기준치_미만_불허() {
        // given
        int ballCount = Balls.BALL_COUNT - 1;

        // when
        List<Ball> balls = generateBalls(ballCount);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Balls(balls);
        });
    }

    private List<Ball> generateBalls(int ballCount) {
        return IntStream.range(0, ballCount)
                .mapToObj(i -> {
                    int value = BallValue.MIN_VALUE + i;
                    return new Ball(value, i);
                })
                .toList();
    }

}
