package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static baseball.constant.MessageConst.*;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidationTest {

    @Test
    @DisplayName("입력값이 정상이면 모든 검증을 통과하는지 테스트")
    void validateInputNumTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String input = "123";

        // then
        assertThatCode(() -> inputValidation.validateInputNum(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력된 문자열이 자연수로 이루어져 있는지 테스트")
    void validateNaturalNumberRangeTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String invalidNaturalNumber1 = "12z";
        String invalidNaturalNumber2 = "120";
        String emptyString = "";
        String blankSpaceString = "   ";

        // then
        assertThatThrownBy(() -> inputValidation.validateNaturalNumberRange(invalidNaturalNumber1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_RANGE_NATURAL_EXCEPTION_MSG);

        assertThatThrownBy(() -> inputValidation.validateNaturalNumberRange(invalidNaturalNumber2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_RANGE_NATURAL_EXCEPTION_MSG);

        assertThatThrownBy(() -> inputValidation.validateNaturalNumberRange(emptyString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_RANGE_NATURAL_EXCEPTION_MSG);

        assertThatThrownBy(() -> inputValidation.validateNaturalNumberRange(blankSpaceString))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_RANGE_NATURAL_EXCEPTION_MSG);
    }

    @Test
    @DisplayName("입력된 문자열의 길이가 4이상인지 테스트")
    void validateInputRangeTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String stringWithFourOrMore = "1234";

        // then
        assertThatThrownBy(() -> inputValidation.validateInputRange(stringWithFourOrMore))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_LENGTH_EXCEPTION_MSG);
    }

    @Test
    @DisplayName("입력된 문자열의 정수들이 서로 다른지 테스트")
    void validateUniqueIntegersTest() {
        // given
        InputValidation inputValidation = new InputValidation();

        // when
        String duplicateIntegers = "777";

        // then
        assertThatThrownBy(() -> inputValidation.validateUniqueIntegers(duplicateIntegers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INPUT_DUPLICATE_EXCEPTION_MSG);
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
                .hasMessageContaining(INPUT_RESTART_EXIT_EXCEPTION_MSG);
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
                .hasMessageContaining(INPUT_RANGE_NATURAL_EXCEPTION_MSG);
    }
}