package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ValidatorTest {

    private static final int INPUT_LENGTH = 3;

    @Test
    @DisplayName("입력숫자검증")
    void validate() {
        String input = "123";

        List<Integer> result = Validator.validate(input);

        assertThat(result.size()).isEqualTo(INPUT_LENGTH);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);
    }

    @Test
    @DisplayName("입력숫자검증_3글자아님_예외발생")
    void validate_NotThreeLetter() {
        String input = "1";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validate(input));
    }

    @Test
    @DisplayName("입력숫자검증_1-9아님_예외발생")
    void validate_NotNaturalLetter() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validate("109"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validate("a12"));
    }

    @Test
    @DisplayName("입력숫자검증_중복숫자_예외발생")
    void validate_NotUniqueLetter() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Validator.validate("111"));
    }


}