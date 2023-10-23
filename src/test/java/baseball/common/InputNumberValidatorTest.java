package baseball.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputNumberValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void validateNotNumber() {
        //given
        String notNumberInput = "aaa";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("4자리 숫자 입력")
    void validateThreeLetters() {
        //given
        String notNumberInput = "1234";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("같은 숫자 입력")
    void validateUniqueCharacters() {
        //given
        String notNumberInput = "555";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("1~9 이외의 숫자 입력")
    void validateRange() {
        String notRangeInput = "980";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notRangeInput));
    }
}