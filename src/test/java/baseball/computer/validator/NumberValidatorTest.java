package baseball.computer.validator;

import static baseball.constant.MessageConstants.DUPLICATE_NUMBER;
import static baseball.constant.MessageConstants.LENGTH_MUST_BE_THREE;
import static baseball.constant.MessageConstants.NATURAL_NUMBER;
import static baseball.constant.MessageConstants.NOT_NUMBER;
import static baseball.validator.NumberValidator.validateAllDigits;
import static baseball.validator.NumberValidator.validateDuplicateNumber;
import static baseball.validator.NumberValidator.validateThreeLength;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @DisplayName("양의 정수인 5를 넣으면 예외가 발생하지 않는다.")
    @Test
    void validate_natural_number() {
        // given
        int invalidNumber = 5;

        // when
        // then
        assertThatCode(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("양의 정수의 경계선인 0을 넣으면 예외가 발생한다.")
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

    @DisplayName("양의 정수의 경계선인 10을 넣으면 예외가 발생한다.")
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

    @DisplayName("경계인 3이라면 False를 반환한다.")
    @Test
    void is_below_required_length() {
        // given
        int invalidNumber = 3;

        // when
        // then
        assertThat(NumberValidator.isBelowThreeLength(invalidNumber)).isFalse();
    }

    @DisplayName("경계인 3보다 작다면 True를 반환한다.")
    @Test
    void is_below_required_length_with_two() {
        // given
        int invalidNumber = 2;

        // when
        // then
        assertThat(NumberValidator.isBelowThreeLength(invalidNumber)).isTrue();
    }

    @DisplayName("중복된 숫자가 있다면 예외가 발생한다.")
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

    @DisplayName("중복된 숫자가 없다면 예외가 발생하지 않는다.")
    @Test
    void validate_duplicate_number_with_valid_number() {
        // given
        int validNumber = 123;

        // when
        // then
        assertThatCode(() -> validateDuplicateNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("3자리 문자 중 숫자 외의 값을 넣으면 예외가 발생한다.")
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

    @DisplayName("3자리 문자 중 숫자만을 넣었으므로 예외가 발생하지 않는다.")
    @Test
    void validate_all_digits_with_only_digit() {
        // given
        String validInput = "489";

        // when
        // then
        assertThatCode(() -> validateAllDigits(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 받는 문자가 3글자이기 때문에 예외가 발생하지 않는다.")
    @Test
    void validate_required_length_with_three() {
        // given
        String validInput = "123";

        // when
        // then
        assertThatCode(() -> validateThreeLength(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 받는 문자가 3글자가 아니라면 예외를 발생한다.")
    @Test
    void validate_required_length_with_not_three() {
        // given
        String invalidInput = "1234";

        // when
        // then
        assertThatThrownBy(() -> validateThreeLength(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidInput + LENGTH_MUST_BE_THREE);
    }

}
