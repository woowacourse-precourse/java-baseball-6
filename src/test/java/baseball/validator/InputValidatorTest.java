package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("숫자 이외의 문자를 입력할 경우 예외 발생")
    void validateNumberTest() {
        String input = "13p";
        assertThatThrownBy(() -> validator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("공백이 입력될 경우 예외 발생")
    void validateSpace() {
        String input = "1 2 3";
        assertThatThrownBy(() -> validator.validateIsNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
