package baseball.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class IntegerRangeValidateTest {

    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 5;

    @ParameterizedTest
    @CsvSource(value = {
            "1", "5"
    })
    void Integer_최소값_최대값_허용(int value) {
        // then
        Assertions.assertDoesNotThrow(() -> {
            IntegerValidators.validateRange(value, MIN_VALUE, MAX_VALUE);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0", "6"
    })
    void Integer_미만값_초과값_불허(int value) {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerValidators.validateRange(value, MIN_VALUE, MAX_VALUE);
        });
    }
}
