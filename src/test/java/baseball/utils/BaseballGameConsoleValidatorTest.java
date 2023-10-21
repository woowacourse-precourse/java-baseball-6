package baseball.utils;

import static baseball.utils.BaseballGameConsoleValidator.isAbleToParseToNum;
import static baseball.utils.BaseballGameConsoleValidator.isRightSize;
import static baseball.utils.BaseballGameConsoleValidator.isValidatedInputForPlayer;
import static baseball.utils.BaseballGameConsoleValidator.isValidatedInputForRestart;
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
    public void isRightSize_sameSize_true() {
        // given
        int input = 3;
        int inputRightSize = 3;

        // when
        boolean isRightSize = isRightSize(input, inputRightSize);

        // then
        assertTrue(isRightSize);
    }

    @Test
    public void isRightSize_differentSize_true() {
        // given
        int input = 2;
        int inputRightSize = 3;

        // when
        boolean isRightSize = isRightSize(input, inputRightSize);

        // then
        assertFalse(isRightSize);
    }

    @Test
    public void isValidatedInputForRestart_validate_true() {
        // given
        String answer = "2";

        // when
        boolean isValidated = isValidatedInputForRestart(answer);

        // then
        assertTrue(isValidated);
    }

    @Test
    public void isValidatedInputForRestart_notRightSize_false() {
        // given
        String answer = "23";

        // when
        boolean isValidated = isValidatedInputForRestart(answer);

        // then
        assertFalse(isValidated);
    }

    @Test
    public void isValidatedInputForRestart_notNumber_false() {
        // given
        String answer = "2a";

        // when
        boolean isValidated = isValidatedInputForRestart(answer);

        // then
        assertFalse(isValidated);
    }

    @Test
    public void isValidatedInputForPlayer_validate_true() {
        // given
        String answer = "234";

        // when
        boolean isValidated = isValidatedInputForPlayer(answer);

        // then
        assertTrue(isValidated);
    }

    @Test
    public void isValidatedInputForPlayer_notRightSize_false() {
        // given
        String answer = "23";

        // when
        boolean isValidated = isValidatedInputForPlayer(answer);

        // then
        assertFalse(isValidated);
    }

    @Test
    public void isValidatedInputForPlayer_notNumber_false() {
        // given
        String answer = "2a3";

        // when
        boolean isValidated = isValidatedInputForPlayer(answer);

        // then
        assertFalse(isValidated);
    }
}