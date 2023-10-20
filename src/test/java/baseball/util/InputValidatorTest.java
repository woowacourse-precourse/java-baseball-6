package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void validateBlankToFail() {
        assertThatThrownBy(() -> InputValidator.validateBlank(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "가", "1"})
    void validateBlankToSuccess(String input) {
        assertDoesNotThrow(() -> InputValidator.validateBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123abc", "12.34", " ", "", "123 ", " 123", "1,000"})
    void validateNumberFormatToFail(String input) {
        assertThatThrownBy(() -> InputValidator.validateNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "123", "4567890", "0001", "9"})
    void validateNumberFormatToSuccess(String input) {
        assertDoesNotThrow(() -> InputValidator.validateNumberFormat(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"10", "00", " ", "", "1 ", " 2", "a", "1a"})
    void validateOneDigitNumberToFail(String input) {
        assertThatThrownBy(() -> InputValidator.validateOneDigitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"})
    void validateOneDigitNumberToSuccess(String input) {
        assertDoesNotThrow(() -> InputValidator.validateOneDigitNumber(input));
    }

}
