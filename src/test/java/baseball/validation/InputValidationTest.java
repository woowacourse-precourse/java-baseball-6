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
        String invalidNaturalNumber1 = "12z";
        String invalidNaturalNumber2 = "120";
        String emptyString = "";
        String blankSpaceString = "   ";

        // then
        assertThatThrownBy(() -> inputValidation.validateNaturalNumber(invalidNaturalNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열은 자연수로만 이루어져야 합니다.");

        assertThatThrownBy(() -> inputValidation.validateNaturalNumber(invalidNaturalNumber2))
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

    @Test
    @DisplayName("입력된 문자열의 정수들이 서로 다른지 테스트")
    void validateUniqueIntegers() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String duplicateIntegers = "777";

        // then
        assertThatThrownBy(() -> inputValidation.validateUniqueIntegers(duplicateIntegers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 서로 다른 정수여야 합니다.");
    }

    @Test
    @DisplayName("재입력된 값이 1 또는 2인지 테스트")
    void validateOneOrTwoTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        int incorrectRetryValue = 77;

        // then
        assertThatThrownBy(() -> inputValidation.validateOneOrTwo(incorrectRetryValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("재입력 값은 1 또는 2여야 합니다.");
    }

    @Test
    @DisplayName("입력된 값이 null인지 테스트")
    void validateNullTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String nullValue = null;

        // then
        assertThatThrownBy(() -> inputValidation.validateNull(nullValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 null일 수 없습니다.");
    }
}