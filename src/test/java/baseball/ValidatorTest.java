package baseball;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    @DisplayName("입력된 수의 길이는 3이다.")
    void validateInputNumberSizeIs3() {
        String numbers = "12";

        assertThrows(IllegalArgumentException.class, ()
                -> Validator.validateInputNumbersSize(numbers));
    }

    @Test
    @DisplayName("입력된 수의 각 자리는 숫자만 올 수 있다.")
    void validateInputNumberIsNumeric() {
        String numbers = "1ab";

        assertThrows(IllegalArgumentException.class, ()
                -> Validator.validateInputNumberIsNumeric(numbers));
    }

    @Test
    @DisplayName("입력된 수는 서로 중복되지 않는다.")
    void validateInputNumberNoDuplicate() {
        String numbers = "333";

        assertThrows(IllegalArgumentException.class, ()
                -> Validator.validateInputNumbersDuplicated(numbers));
    }
}