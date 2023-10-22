package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SingleDigitValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"10", "00", " ", "", "1 ", " 2", "a", "1a"})
    void validateOneDigitNumberToFail(String input) {
        assertThatThrownBy(() -> SingleDigitValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "9"})
    void validateOneDigitNumberToSuccess(String input) {
        assertDoesNotThrow(() -> SingleDigitValidator.validate(input));
    }
}
