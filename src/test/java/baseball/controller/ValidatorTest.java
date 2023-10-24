package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValidatorTest {
    @Test
    @DisplayName("입력값이 숫자가 맞다.")
    void 플레이어_숫자_입력_참() {
        String validInput = "123";
        assertTrue(Validator.validateInputIsNumber(validInput));
    }

    @Test
    @DisplayName("입력값이 숫자가 아니다.")
    void 플레이어_숫자외입력_거짓() {
        String invalidInput = "1b3";
        assertFalse(Validator.validateInputIsNumber(invalidInput));
    }

    @Test
    @DisplayName("입력한 숫자의 길이가 3이다")
    void 플레이어_숫자_입력_길이3() {
        String validInput = "123";
        assertTrue(Validator.validateInputLength(validInput));
    }
}
