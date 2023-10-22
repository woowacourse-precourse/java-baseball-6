package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @DisplayName("숫자 이외의 문자를 입력하면 예외 발생")
    @Test
    void throwIfNonNumericInput() {
        String input = "12a";
        assertThatThrownBy(
                () -> InputValidator.validateNumericInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 재실행 입력 값이 1 또는 2가 아니면 예외 발생")
    @Test
    void throwIfInvalidRestartInput() {
        String input = "x";

        assertThatThrownBy(
                () -> InputValidator.validateNumericInput(input)
        ).isInstanceOf(IllegalArgumentException.class);
    }

}
