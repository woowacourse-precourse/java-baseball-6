package baseball.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @Test
    void null이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validate(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void 빈_문자열이면_예외가_발생한다(String input) {
        assertThatThrownBy(() -> InputValidator.validate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상_입력이면_예외가_발생하지_않는다() {
        assertThatCode(() -> InputValidator.validate("123"))
                .doesNotThrowAnyException();
    }
}
