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
}
