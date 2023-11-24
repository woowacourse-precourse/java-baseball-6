package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @DisplayName("숫자가 아닐 경우 예외가 발생한다.")
    @ValueSource(strings = "a, ㄱ, ;, !")
    @ParameterizedTest
    void validateNumberFormat(String input) {
        assertThatThrownBy(() -> validator.validateNumberFormat(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
