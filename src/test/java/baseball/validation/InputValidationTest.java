package baseball.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.view.InputValidation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("InputValidation의")
public class InputValidationTest {

    private final InputValidation validation = new InputValidation();

    @Test
    @DisplayName("야구숫자 입력시 입력 값의 길이가 3이 아닌경우 에외 발생")
    void validate_number_length_three() {
        String input = "1234";
        assertThatThrownBy(() -> validation.checkLengthThree(input))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("재시작 입력시 입력 값의 길이가 1이 아닌경우 예외 발생")
    void validate_number_length_one() {
        String input = "12";
        assertThatThrownBy(() -> validation.checkLengthOne(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력시 문자가 입력되면 예외 발생")
    void validate_string() {
        String input = "12Q";
        assertThatThrownBy(() -> validation.checkStringRegex(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("재시작시 입력값이 1 또는 2가 아니면 예외 발생")
    void validate_one_or_two() {
        String input = "3";
        assertThatThrownBy(() -> validation.checkOneOrTwoRegex(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
