package validator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberInputValidatorTest {
    @Test
    public void testValidNumberUnderThreeDigits() {
        NumberInputValidator numberInputValidator = new NumberInputValidator();
        try {
            numberInputValidator.vaildNumberUnderThreeDigits("1");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("공의 개수가 3개 보다 적어요.", e.getMessage());
        }
    }

    @Test
    public void testVaildNumberOverThreeDigits() {
        NumberInputValidator numberInputValidator = new NumberInputValidator();
        try {
            numberInputValidator.vaildNumberOverThreeDigits("1234");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("공의 개수가 3개 보다 많아요.", e.getMessage());
        }
    }

    @Test
    public void testValidContainSameNumber() {
        NumberInputValidator numberInputValidator = new NumberInputValidator();
        try {
            numberInputValidator.validContainSameNumber("119");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("같은 숫자가 포함되었어요.", e.getMessage());
        }
    }
}