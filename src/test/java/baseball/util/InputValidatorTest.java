package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputValidatorTest {
    private InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("숫자가 아닌 값 예외")
    void testValidateDigits() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateDigits("가나다"))
                .withMessage("[ERROR] 숫자만 입력해야 합니다.");
    }

    @Test
    @DisplayName("배열 크기 예외")
    void testValidateInputSize() {
        List<Integer> list = List.of(1, 2, 3, 4, 4);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateInputSize(list))
                .withMessage("[ERROR] 3 자리 수를 입력해야 합니다.");
    }

    @Test
    @DisplayName("배열 범위 예외")
    void testValidateNumberRange() {
        List<Integer> list = List.of(9, 10, 11, 22);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateNumberRange(list))
                .withMessage("[ERROR] 1-9 까지의 수만 입력해야 합니다.");
    }

    @Test
    @DisplayName("1,2 가 아닌 값 예외")
    void testValidateCommandAfterGame() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateCommandAfterGame("4"))
                .withMessage("[ERROR] 1 또는 2 만 입력할 수 있습니다.");
    }

    @Test
    @DisplayName("중복값 예외")
    void testValidateDuplicatedNumbers() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> inputValidator.validateDuplicate(List.of(1,1,1)))
                .withMessage("[ERROR] 중복이 존재합니다.");
    }
}
