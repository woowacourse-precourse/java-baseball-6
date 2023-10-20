package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValueRangeFailTest {

    @Test
    void 공_최소값_미만_불허() {
        // given
        int value = BallValue.BALL_MIN_VALUE - 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallValue(value);
        });
    }

    @Test
    void 공_최대값_초과_불허() {
        // given
        int value = BallValue.BALL_MAX_VALUE + 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallValue(value);
        });
    }

}
