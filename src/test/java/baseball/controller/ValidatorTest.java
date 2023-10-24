package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
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
    @DisplayName("입력한 숫자의 길이가 3이다.")
    void 플레이어_숫자_입력_길이3() {
        String validInput = "123";
        assertTrue(Validator.validateInputLength(validInput));
    }

    @Test
    @DisplayName("입력한 숫자의 길이가 4이다.")
    void 플레이어_숫자_입력_길이4() {
        String invalidInput = "1234";
        assertFalse(Validator.validateInputLength(invalidInput));
    }

    @Test
    @DisplayName("입력한 숫자가 자릿수마다 다르다")
    void 플레이어_숫자_입력_자릿수마다_다르다() {
        String validInput = "123";
        assertTrue(Validator.validateInputWithDifferentDigit(validInput));
    }

    @Test
    @DisplayName("입력한 숫자가 자릿수마다 다르지 않다")
    void 플레이어_숫자_입력_자릿수마다_다르지않다() {
        String validInput = "122";
        assertFalse(Validator.validateInputWithDifferentDigit(validInput));
    }

    @Test
    @DisplayName("게임중 잘못된 입력의 경우 에외가 발생한다.")
    void 게임중_플레이어_잘못된_입력_예외발생() {
        String invalidInput = "";
        assertThatThrownBy(() ->
                Validator.validateUserInput(invalidInput))
                .isInstanceOf(IllegalArgumentException.class
                );
    }


}
