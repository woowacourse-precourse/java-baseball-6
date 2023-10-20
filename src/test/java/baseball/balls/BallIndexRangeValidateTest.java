package baseball.balls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallIndexRangeValidateTest {

    private final int BALL_MIN_INDEX = 0;
    private final int BALL_MAX_INDEX = Balls.BALL_COUNT - 1;

    @Test
    void 인덱스_최소값_허용() {
        // given
        int index = BALL_MIN_INDEX;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallIndex(index);
        });
    }

    @Test
    void 인덱스_최대값_허용() {
        // given
        int index = BALL_MAX_INDEX;

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new BallIndex(index);
        });
    }

    @Test
    void 인덱스_최소값_미만_불허() {
        // given
        int index = BALL_MIN_INDEX - 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallIndex(index);
        });
    }

    @Test
    void 인덱스_최대값_초과_불허() {
        // given
        int index = BALL_MAX_INDEX + 1;

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallIndex(index);
        });
    }

}
