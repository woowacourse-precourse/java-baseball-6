package baseball;

import baseball.validator.CommandValidator;
import baseball.validator.NumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputTest {
    @DisplayName("올바른 숫자 범위 테스트1")
    @Test
    void validateRange() {
        final String input = "0";

        assertThrows(IllegalArgumentException.class, ()->{
            NumbersValidator.validateRange(input);
        });
    }

    @DisplayName("올바른 숫자 범위 테스트2")
    @Test
    void validateRange2() {
        final String input = "10";

        assertThrows(IllegalArgumentException.class, ()->{
            NumbersValidator.validateRange(input);
        });
    }

    @DisplayName("숫자로 이루어진 문자열인지 확인하는 테스트")
    @Test
    void validateNonNumeric() {
        final String input = "^%3";

        assertThrows(IllegalArgumentException.class, ()->{
            NumbersValidator.validateNonNumeric(input);
        });
    }

    @DisplayName("3자리 수인지 확인하는 테스트")
    @Test
    void validateDigit() {
        final String input = "";

        assertThrows(IllegalArgumentException.class, ()->{
            NumbersValidator.validateDigit(input);
        });
    }

    @DisplayName("리스트에 중복되는 숫자가 있는지 확인하는 테스트")
    @Test
    void validateDuplicateNumber() {
        final String input = "122";

        assertThrows(IllegalArgumentException.class, ()->{
            NumbersValidator.validateDuplicateNumber(input);
        });
    }
}