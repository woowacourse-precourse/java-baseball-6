package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.controller.InputValidator;
import org.junit.jupiter.api.Test;


public class InputValidatorTest {
    InputValidator inputValidator = new InputValidator();

    @Test
    void isTreeLengthLetterTest_caseTrue() {
        String playerInput = "가나라";

        assertThat(inputValidator.isTreeLengthLetter(playerInput)).isTrue();
    }

    @Test
    void isTreeLengthLetterTest_caseFalse() {
        String playerInput1 = "가나다라";
        String playerInput2 = "12";

        assertThat(inputValidator.isTreeLengthLetter(playerInput1)).isFalse();
        assertThat(inputValidator.isTreeLengthLetter(playerInput2)).isFalse();
    }

    @Test
    void isAllDigitTest_caseTrue() {
        String playerInput = "4424";

        assertThat(inputValidator.isAllDigit(playerInput)).isTrue();
    }

    @Test
    void isAllDigitTest_caseFalse() {
        String playerInput1 = "english";
        String playerInput2 = "한글";

        assertThat(inputValidator.isAllDigit(playerInput1)).isFalse();
        assertThat(inputValidator.isAllDigit(playerInput2)).isFalse();
    }

    @Test
    void hasDuplicationTest_caseTrue() {
        String playerInput = "12345";

        assertThat(inputValidator.hasDuplicateChars(playerInput)).isTrue();
    }

    @Test
    void hasDuplicationTest_caseFalse() {
        String playerInput = "13345";

        assertThat(inputValidator.hasDuplicateChars(playerInput)).isFalse();
    }
}
