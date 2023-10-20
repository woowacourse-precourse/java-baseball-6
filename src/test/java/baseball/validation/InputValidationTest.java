package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

    @Test
    @DisplayName("입력된 문자열이 자연수로 이루어져 있는지 테스트")
    void validateNaturalNumberTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String invalidNaturalNumber = "12z";
        String emptyString = "";
        String blankSpaceString = "   ";

        // then
        assertThatThrownBy(() -> inputValidation.validateNaturalNumber(invalidNaturalNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열은 자연수로만 이루어져야 합니다.");

        assertThatThrownBy(() -> inputValidation.validateNaturalNumber(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열은 자연수로만 이루어져야 합니다.");

        assertThatThrownBy(() -> inputValidation.validateNaturalNumber(blankSpaceString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열은 자연수로만 이루어져야 합니다.");
    }

    @Test
    @DisplayName("입력된 문자열의 길이가 4이상인지 테스트")
    void isLengthAtLeastFourTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String stringWithFourOrMore = "1234";

        // then
        assertThatThrownBy(() -> inputValidation.isLengthAtLeastFour(stringWithFourOrMore))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 3 이하여야 합니다.");
    }
}