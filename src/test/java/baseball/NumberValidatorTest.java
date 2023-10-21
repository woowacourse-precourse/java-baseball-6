package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.NumberValidator;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {
    NumberValidator numberValidator = new NumberValidator();

    @Test
    void isTreeLengthLetterTest_caseTrue() {
        String playerInput = "가나라";

        assertThat(numberValidator.isTreeLengthLetter(playerInput)).isTrue();
    }

    @Test
    void isTreeLengthLetterTest_caseFalse() {
        String playerInput1 = "가나다라";
        String playerInput2 = "12";

        assertThat(numberValidator.isTreeLengthLetter(playerInput1)).isFalse();
        assertThat(numberValidator.isTreeLengthLetter(playerInput2)).isFalse();
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

}
