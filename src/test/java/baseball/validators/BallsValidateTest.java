package baseball.validators;

import baseball.balls.Ball;
import baseball.testUtils.BallsGeneratorUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsValidateTest {

    private final int BALL_COUNT = 3;
    private final int BALL_MIN_VALUE = 1;

    @Test
    void 공_개수_기준치_동일_허용() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, true, true);

        // then
        Assertions.assertDoesNotThrow(() -> {
            ListValidators.validateSize(balls, BALL_COUNT);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "" + (BALL_COUNT - 1),
            "" + (BALL_COUNT + 1),
    })
    void 공_개수_기준치_미만_혹은_초과_불허(int ballCount) {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(ballCount, BALL_MIN_VALUE, true, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            ListValidators.validateSize(balls, BALL_COUNT);
        });
    }

}
