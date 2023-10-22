package baseball;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValidatorTest {

    @Test
    @Tag("입력값이 숫자가 아닌 경우")
    public void testValidateNumberInput_NotANumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumberInput("abc");
        }, GameConstants.NOT_A_NUMBER);
    }

    @Test
    @Tag("입력값의 길이가 유효하지 않은 경우")
    public void testValidateNumberInput_NotValidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumberInput("1234");
        }, GameConstants.NOT_VALID_LENGTH);
    }

    @Test
    @Tag("입력값에 중복된 숫자가 있는 경우")
    public void testValidateNumberInput_HasDuplicateNumbers() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumberInput("112");
        }, GameConstants.DUPLICATE_NUMBER);
    }

    @Test
    @Tag("입력값의 숫자가 범위를 벗어난 경우")
    public void testValidateNumberInput_OutOfRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateNumberInput("019");
        }, GameConstants.OUT_OF_RANGE);
    }

    @Test
    @Tag("사용자의 선택지가 유효하지 않은 경우")
    public void testValidateChoiceInput_NotAValidChoice() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputValidator.validateChoiceInput("3");
        }, GameConstants.NOT_A_VALID_CHOICE);
    }
}
