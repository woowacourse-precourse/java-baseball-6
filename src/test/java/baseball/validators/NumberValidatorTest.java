package baseball.validators;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    public void 올바른_입력으로_검증을_통과한다() {
        String inputString = "123";
        assertDoesNotThrow(() -> NumberValidator.validateNumber(inputString));
    }

    @Test
    public void 주어진_범위가_아닌_문자를_입력하여_예외를_반환한다() {
        // given
        String numbers = "a93";

        // when
        assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.validateNumber(numbers));
    }

    @Test
    public void 입력의_크기를_초과하여_예외를_반환한다() {
        // given
        String numbers = "1234";

        // when
        assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.validateNumber(numbers));
    }

    @Test
    public void 중복되는_숫자가_입력되어_예외를_반환한다() {
        // given
        String numbers = "334";

        // when
        assertThrows(IllegalArgumentException.class,
                () -> NumberValidator.validateNumber(numbers));
    }
}