package baseball.validators;

import baseball.balls.BallValue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallValueValidateTest {

    private final int MIN_VALUE = BallValue.MIN_VALUE;
    private final int MAX_VALUE = BallValue.MAX_VALUE;

    @ParameterizedTest
    @CsvSource(value = {
            "" + MIN_VALUE,
            "" + MAX_VALUE,
    })
    void BallValue_최소값과_최대값_허용(int value) {
        // then
        Assertions.assertDoesNotThrow(() -> {
            BallValueValidators.validateValueRange(value);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "" + (MIN_VALUE - 1),
            "" + (MAX_VALUE + 1),
    })
    void BallValue_미만값과_초과값_불허(int value) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallValueValidators.validateValueRange(value);
        });
    }

}
