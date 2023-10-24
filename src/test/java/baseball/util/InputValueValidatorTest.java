package baseball.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputValueValidatorTest {
    private final int numberOfDigits = 3;

    @Test
    public void testCheckBlank() {
        String inputValue = "";
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer(inputValue, numberOfDigits));
    }

    @Test
    public void testCheckWhiteSpace() {
        String inputValue = "123 ";
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer(inputValue, numberOfDigits));
    }

    @Test
    public void testCheckIsNumber() {
        String inputValue = "1ㅁ23";
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer(inputValue, numberOfDigits));
    }


    @Test
    public void testCheckNumberOfDigits() {
        String inputValue = "1234";
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer(inputValue, numberOfDigits));
    }

    @Test
    public void testCheckDuplicateNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer("112", numberOfDigits));
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer("121", numberOfDigits));
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputAnswer("211", numberOfDigits));
    }

    @Test
    public void testCheckContinueFlag() {
        assertThrows(IllegalArgumentException.class,
                () -> InputValueValidator.checkValidInputContinueFlag("3"));
    }
}
