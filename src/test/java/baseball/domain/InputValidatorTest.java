package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("재시작, 종료 input 검증")
    void validEndNumber() {
        String input = "1";

        assertThat(inputValidator.validEndNumber(input)).isEqualTo(1);

        input = "2";

        assertThat(inputValidator.validEndNumber(input)).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 이외의 다른 문자가 있어선 안된다.")
    void validEndNumber_fail_char() {
        String input = "o";

        assertThatThrownBy(() -> inputValidator.validEndNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1 또는 2만 된다.")
    void validEndNumber_one_or_two() {
        String input = "3";

        assertThatThrownBy(() -> inputValidator.validEndNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1자리의 숫자만 가능하다.")
    void validEndNumber_fail_length() {
        String input = "12";

        assertThatThrownBy(() -> inputValidator.validEndNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 진행시 숫자 입력 검증")
    void validateInputNumbers() {
        String input = "123";

        assertThat(inputValidator.validateInputNumbers(input)).isEqualTo(List.of(1, 2, 3));

        input = "745";

        assertThat(inputValidator.validateInputNumbers(input)).isEqualTo(List.of(7, 4, 5));
    }

    @Test
    @DisplayName("input 숫자 길이 검증")
    void validateInputNumbers_fail_length() {
        String input = "12335";

        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input 문자열 검증")
    void validateInputNumbers_fail_char() {
        String input = "12x";
        String input1 = "xz1";
        String input2 = "abx";

        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input 숫자 범위 검증 - 0 미포함")
    void validateInputNumbers_fail_numberRange() {
        String input = "013";

        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("input 중복 숫자 검증")
    void validateInputNumbers_fail_DuplicateNumber() {
        String input = "113";

        assertThatThrownBy(() -> inputValidator.validateInputNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}