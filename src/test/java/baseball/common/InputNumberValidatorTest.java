package baseball.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("게임 진행 시 입력 숫자 검증")
class InputNumberValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 문자 입력 시 예외 발생")
    void validateNotNumber() {
        //given
        String notNumberInput = "aaa";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("4자리 숫자 입력 시 예외 발생")
    void validateThreeLetters() {
        //given
        String notNumberInput = "1234";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("같은 숫자 입력 시 예외 발생")
    void validateUniqueCharacters() {
        //given
        String notNumberInput = "555";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notNumberInput));
    }

    @Test
    @DisplayName("1~9 이외의 숫자 입력 시 예외 발생")
    void validateRange() {
        String notRangeInput = "980";
        assertThrows(IllegalArgumentException.class, () -> InputNumberValidator.validate(notRangeInput));
    }
}