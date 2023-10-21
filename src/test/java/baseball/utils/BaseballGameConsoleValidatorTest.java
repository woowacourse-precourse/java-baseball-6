package baseball.utils;

import static baseball.utils.BaseballGameConsoleValidator.isAbleToParseToNum;
import static baseball.utils.BaseballGameConsoleValidator.isValidatedInput;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BaseballGameConsoleValidatorTest {

    @Test
    public void isAbleToParseToNum_number_true() {
        // given
        String testNum = "123";

        // when
        boolean ableToParseToNum = isAbleToParseToNum(testNum);

        // then
        assertTrue(ableToParseToNum);
    }

    @Test
    public void isAbleToParseToNum_numberWithChar_false() {
        // given
        String testNum = "1a3";

        // when
        boolean ableToParseToNum = isAbleToParseToNum(testNum);

        // then
        assertFalse(ableToParseToNum);
    }

    @Test
    public void isValidatedInput_numberAndRightSize_true() {
        // given
        String testNum = "123";

        // when
        boolean validatedInput = isValidatedInput(testNum, 3);

        // then
        assertTrue(validatedInput);
    }

    @Test
    public void isValidatedInput_numberWithCharAndRightSize_false() {
        // given
        String testNum = "1a3";

        // when
        boolean validatedInput = isValidatedInput(testNum, 3);

        // then
        assertFalse(validatedInput);
    }

    @Test
    public void isValidatedInput_numberAndWrongSize_false() {
        // given
        String testNum = "123";

        // when
        boolean validatedInput = isValidatedInput(testNum, 2);

        // then
        assertFalse(validatedInput);
    }
}