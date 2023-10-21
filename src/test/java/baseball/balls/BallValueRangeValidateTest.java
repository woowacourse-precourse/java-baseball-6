package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallValueRangeValidateTest {

    private final int MIN_VALUE = BallValue.MIN_VALUE;
    private final int MAX_VALUE = BallValue.MAX_VALUE;

    @Test
    void 값_최소값_허용() {
        // given
        int value = MIN_VALUE;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallValue(value);
        });
    }

    @Test
    void 값_최대값_허용() {
        // given
        int value = MAX_VALUE;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallValue(value);
        });
    }

    @Test
    void 값_최소값_미만_불허() {
        // given
        int value = MIN_VALUE - 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallValue(value);
        });
    }

    @Test
    void 값_최대값_초과_불허() {
        // given
        int value = MAX_VALUE + 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallValue(value);
        });
    }

}
