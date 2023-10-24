package baseball.controller;

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
}
