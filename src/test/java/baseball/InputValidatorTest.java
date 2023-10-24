package baseball;

import baseball.common.GameConstants;
import baseball.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    @DisplayName("입력값이 숫자가 아닌 경우")
    public void testValidateNumberInput_NotANumber() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberInput("abc"));
        assertEquals(GameConstants.NOT_A_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("입력값의 길이가 유효하지 않은 경우")
    public void testValidateNumberInput_NotValidLength() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberInput("1234"));
        assertEquals(GameConstants.NOT_VALID_LENGTH, exception.getMessage());
    }

    @Test
    @DisplayName("입력값에 중복된 숫자가 있는 경우")
    public void testValidateNumberInput_HasDuplicateNumbers() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberInput("112"));
        assertEquals(GameConstants.DUPLICATE_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("입력값의 숫자가 범위를 벗어난 경우")
    public void testValidateNumberInput_OutOfRange() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateNumberInput("019"));
        assertEquals(GameConstants.OUT_OF_RANGE, exception.getMessage());
    }

    @Test
    @DisplayName("사용자의 선택지가 유효하지 않은 경우")
    public void testValidateChoiceInput_NotAValidChoice() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateChoiceInput("3"));
        assertEquals(GameConstants.NOT_A_VALID_CHOICE, exception.getMessage());
    }

    @Test
    @DisplayName("사용자의 선택지가 숫자가 아닌 경우")
    public void testValidateChoiceInput_NotANumbers() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> InputValidator.validateChoiceInput("abc"));
        assertEquals(GameConstants.NOT_A_NUMBER, exception.getMessage());
    }
}
