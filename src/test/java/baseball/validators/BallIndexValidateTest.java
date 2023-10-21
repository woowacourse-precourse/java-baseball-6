package baseball.validators;

import baseball.balls.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallIndexValidateTest {

    private final int MIN_INDEX = 0;
    private final int MAX_INDEX = Balls.BALL_COUNT - 1;

    @ParameterizedTest
    @CsvSource(value = {
            "" + MIN_INDEX,
            "" + MAX_INDEX,
    })
    void BallIndex_최소값과_최대값_허용(int index) {
        // then
        Assertions.assertDoesNotThrow(() -> {
            BallIndexValidators.validateIndexRange(index);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "" + (MIN_INDEX - 1),
            "" + (MAX_INDEX + 1),
    })
    void BallIndex_미만값과_초과값_불허(int index) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallIndexValidators.validateIndexRange(index);
        });
    }

}
