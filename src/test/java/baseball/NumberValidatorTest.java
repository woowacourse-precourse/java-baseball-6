package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import baseball.controller.BaseBallConstants;
import baseball.util.InputValidator;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    InputValidator numberValidator = new InputValidator();

    @Test
    void isTreeLengthLetterTest_caseTrue() {
        String playerInput = "가나라";

        assertThat(numberValidator.isThreeLengthLetter(playerInput)).isTrue();
    }

    @Test
    void isTreeLengthLetterTest_caseFalse() {
        String playerInput1 = "가나다라";
        String playerInput2 = "12";

        assertThat(numberValidator.isThreeLengthLetter(playerInput1)).isFalse();
        assertThat(numberValidator.isThreeLengthLetter(playerInput2)).isFalse();
    }

    @Test
    void isAllDigitTest_caseTrue() {
        String playerInput = "4424";

        assertThat(numberValidator.isAllDigit(playerInput)).isTrue();
    }

    @Test
    void isAllDigitTest_caseFalse() {
        String playerInput1 = "english";
        String playerInput2 = "한글";

        assertThat(numberValidator.isAllDigit(playerInput1)).isFalse();
        assertThat(numberValidator.isAllDigit(playerInput2)).isFalse();
    }

    @Test
    void hasDuplicateCharsTest_caseTrue() {
        String playerInput = "13345";

        assertThat(numberValidator.hasDuplicateChars(playerInput)).isTrue();
    }

    @Test
    void hasDuplicateCharsTest_caseFalse() {
        String playerInput = "12345";

        assertThat(numberValidator.hasDuplicateChars(playerInput)).isFalse();
    }

    @Test
    void isValidNumberTest_caseTrue() {
        String playerInput = "123";

        assertThat(numberValidator.isValidNumbers(playerInput)).isTrue();
    }

    @Test
    void testIsValidNumber_caseWrongLength() {
        String errorMessage = BaseBallConstants.WRONG_LENGTH_THROW_MESSAGE;
        String playerInput = "1234";

        try {
            numberValidator.isValidNumbers(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseWrongRange() {
        String errorMessage = BaseBallConstants.WRONG_RANGE_THROW_MESSAGE;
        String playerInput = "0일공";

        try {
            numberValidator.isValidNumbers(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseDuplicateChars() {
        String errorMessage = BaseBallConstants.DUPLICATE_INPUT_MESSAGE;
        String playerInput = "332";

        try {
            numberValidator.isValidNumbers(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseTrue() {
        String playerInput = "345";

        assertThat(numberValidator.isValidNumbers(playerInput)).isTrue();
    }

    @Test
    void testIsValidContinueGameChoice() {
        String playerInput1 = "1";
        String playerInput2 = "2";
        String playerInput3 = "종료";
        String errorMessage = BaseBallConstants.WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE;

        assertThat(numberValidator.isValidContinueGameChoice(playerInput1)).isTrue();
        assertThat(numberValidator.isValidContinueGameChoice(playerInput2)).isTrue();
        try {
            numberValidator.isValidContinueGameChoice(playerInput3);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }
}
