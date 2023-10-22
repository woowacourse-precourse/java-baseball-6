package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DigitsOnlyValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123abc", "12.34", " ", "", "123 ", " 123", "1,000"})
    void validateDigitsOnlyToFail(String input) {
        assertThatThrownBy(() -> DigitsOnlyValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "123", "4567890", "0001", "9"})
    void validateDigitsOnlyToSuccess(String input) {
        assertDoesNotThrow(() -> DigitsOnlyValidator.validate(input));
    }
}
