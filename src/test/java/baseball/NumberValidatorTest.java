package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

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

    @Test
    void isValidNumberTest_caseTrue() {
        String playerInput = "123";

        assertThat(numberValidator.isValidNumber(playerInput)).isTrue();
    }

    @Test
    void testIsValidNumber_caseWrongLength() {
        String errorMessage = "세 자리 숫자를 입력하세요.";
        String playerInput = "1234";

        try {
            numberValidator.isValidNumber(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseWrongRange() {
        String errorMessage = "1-9 사이의 정수를 입력하세요.";
        String playerInput = "0일공";

        try {
            numberValidator.isValidNumber(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseDuplicateChars() {
        String errorMessage = "중복되지 않는 서로 다른 숫자를 입력해주세요.";
        String playerInput = "332";

        try {
            numberValidator.isValidNumber(playerInput);
            fail("IllegalArgumentException 가 발생해야한다.");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo(errorMessage);
        }
    }

    @Test
    void testIsValidNumber_caseTrue() {
        String playerInput = "345";

        assertThat(numberValidator.isValidNumber(playerInput)).isTrue();
    }

}
