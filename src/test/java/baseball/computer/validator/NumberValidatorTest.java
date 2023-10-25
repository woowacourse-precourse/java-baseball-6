package baseball.computer.validator;

import static baseball.constant.MessageConstants.DUPLICATE_NUMBER;
import static baseball.constant.MessageConstants.LENGTH_MUST_BE_ONE;
import static baseball.constant.MessageConstants.LENGTH_MUST_BE_THREE;
import static baseball.constant.MessageConstants.NATURAL_NUMBER;
import static baseball.constant.MessageConstants.NOT_NUMBER;
import static baseball.constant.MessageConstants.NUMBER_MUST_BE_ONE_OR_TWO;
import static baseball.validator.NumberValidator.validateAllDigits;
import static baseball.validator.NumberValidator.validateDuplicateNumber;
import static baseball.validator.NumberValidator.validateOneLength;
import static baseball.validator.NumberValidator.validateOneOrTwo;
import static baseball.validator.NumberValidator.validateThreeLength;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @DisplayName("validateNaturalNumber()로 양의 정수인 5를 넣으면 예외가 발생하지 않는다.")
    @Test
    void validate_natural_number() {
        // given
        int invalidNumber = 5;

        // when
        // then
        assertThatCode(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateNaturalNumber()로 양의 정수의 경계선인 0을 넣으면 예외가 발생한다.")
    @Test
    void validate_natural_number_with_zero() {
        // given
        int invalidNumber = 0;

        // when
        // then
        assertThatThrownBy(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NATURAL_NUMBER);
    }

    @DisplayName("validateNaturalNumber()로 양의 정수의 경계선인 10을 넣으면 예외가 발생한다.")
    @Test
    void validate_natural_number_with_ten() {
        // given
        int invalidNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NATURAL_NUMBER);
    }

    @DisplayName("isBelowThreeLength()로 경계인 3이라면 False를 반환한다.")
    @Test
    void is_below_required_length() {
        // given
        int invalidNumber = 3;

        // when
        // then
        assertThat(NumberValidator.isBelowThreeLength(invalidNumber)).isFalse();
    }

    @DisplayName("isBelowThreeLength()로 경계인 3보다 작다면 True를 반환한다.")
    @Test
    void is_below_required_length_with_two() {
        // given
        int invalidNumber = 2;

        // when
        // then
        assertThat(NumberValidator.isBelowThreeLength(invalidNumber)).isTrue();
    }

    @DisplayName("validateDuplicateNumber()로 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void validate_duplicate_number_with_duplicate_number() {
        // given
        int duplicateNumber = 122;

        // when
        // then
        assertThatThrownBy(() -> validateDuplicateNumber(duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(duplicateNumber + DUPLICATE_NUMBER);
    }

    @DisplayName("validateDuplicateNumber()로 중복된 숫자가 없다면 예외가 발생하지 않는다.")
    @Test
    void validate_duplicate_number_with_valid_number() {
        // given
        int validNumber = 123;

        // when
        // then
        assertThatCode(() -> validateDuplicateNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateAllDigits()로 3자리 문자 중 숫자 외의 값을 넣으면 예외가 발생한다.")
    @Test
    void validate_all_digits_with_string() {
        // given
        String invalidInput = "12a";

        // when
        // then
        assertThatThrownBy(() -> validateAllDigits(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidInput + NOT_NUMBER);
    }

    @DisplayName("validateAllDigits()로 3자리 문자 중 숫자만을 넣었으므로 예외가 발생하지 않는다.")
    @Test
    void validate_all_digits_with_only_digit() {
        // given
        String validInput = "489";

        // when
        // then
        assertThatCode(() -> validateAllDigits(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateThreeLength()로 입력 받는 문자가 3글자이기 때문에 예외가 발생하지 않는다.")
    @Test
    void validate_three_length_with_three() {
        // given
        String validInput = "123";

        // when
        // then
        assertThatCode(() -> validateThreeLength(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("validateThreeLength()로 입력 받는 문자가 3글자가 아니라면 예외를 발생한다.")
    @Test
    void validate_three_length_with_not_three() {
        // given
        String invalidInput = "1234";

        // when
        // then
        assertThatThrownBy(() -> validateThreeLength(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidInput + LENGTH_MUST_BE_THREE);
    }

    @Test
    @DisplayName("validateOneLength()로 길이가 1인 문자열은 예외가 발생하지 않는다.")
    void validate_one_length_should_not_throw_exception_for_valid_one_length_strings() {
        // given
        String validInput = "1";

        // when
        // then
        assertThatCode(() -> validateOneLength(validInput))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("validateOneLength()로  길이가 1이 아닌 문자열은 예외를 발생한다.")
    void validate_one_length_should_throw_exception_for_invalid_length_strings() {
        // given
        String invalidInput = "12";

        // when
        // then
        assertThatThrownBy(() -> validateOneLength(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(invalidInput + LENGTH_MUST_BE_ONE);
    }

    @Test
    @DisplayName("validateOneOrTwo()로 '1' 또는 '2' 문자열은 예외가 발생하지 않는다.")
    void validate_one_or_two_should_not_throw_exception_for_valid_inputs() {
        // given
        String validInput1 = "1";
        String validInput2 = "2";

        // when
        // then
        assertThatCode(() -> validateOneOrTwo(validInput1))
                .doesNotThrowAnyException();
        assertThatCode(() -> validateOneOrTwo(validInput2))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("validateOneOrTwo로 '1' 또는 '2' 이외의 문자열은 예외를 발생한다.")
    void validate_one_or_two_should_throw_exception_for_invalid_inputs() {
        // given
        String invalidInput = "12";

        // when
        // then
        assertThatThrownBy(() -> validateOneOrTwo(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(invalidInput + NUMBER_MUST_BE_ONE_OR_TWO);
    }

}
