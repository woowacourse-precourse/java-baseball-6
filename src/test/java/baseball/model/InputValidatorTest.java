package baseball.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class InputValidatorTest {
    @Test
    public void testIsValidUserInputValidInput() {
        UserInputValidator validator = new UserInputValidator();

        List<Integer> result = validator.isValidUserInput("123");

        assertNotNull(result);
        Set<Integer> uniqueSet = new HashSet<>(result);
        assertEquals(3, uniqueSet.size());
    }

    @Test
    public void testIsValidUserInputInvalidInput() {
        UserInputValidator validator = new UserInputValidator();

        assertInvalidInput(validator, "abc");
        assertInvalidInput(validator, "");
        assertInvalidInput(validator, "112");
        assertInvalidInput(validator, "1234");
    }

    private void assertInvalidInput(UserInputValidator validator, String input) {
        assertThrows(IllegalArgumentException.class, () -> validator.isValidUserInput(input));
    }
}
