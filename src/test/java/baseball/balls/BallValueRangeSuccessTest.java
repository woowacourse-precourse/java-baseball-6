package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValueRangeSuccessTest {

    @Test
    void 공_최소값_허용() {
        // given
        int value = BallValue.BALL_MIN_VALUE;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallValue(value);
        });
    }

    @Test
    void 공_최대값_허용() {
        // given
        int value = BallValue.BALL_MAX_VALUE;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallValue(value);
        });
    }

}
