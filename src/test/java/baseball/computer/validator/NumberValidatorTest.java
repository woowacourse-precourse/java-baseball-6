package baseball.computer.validator;

import static baseball.validator.NumberValidator.LENGTH;
import static baseball.validator.NumberValidator.validateAllDigits;
import static baseball.validator.NumberValidator.validateDuplicateNumber;
import static baseball.validator.NumberValidator.validateRequiredLength;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.validator.NumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @DisplayName("양의 정수인 5를 넣으면 예외가 발생하지 않는다.")
    @Test
    void validateNaturalNumber() {
        // given
        int invalidNumber = 5;

        // when
        // then
        assertThatCode(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("양의 정수의 경계선인 0을 넣으면 예외가 발생한다.")
    @Test
    void validateNaturalNumberWithZero() {
        // given
        int invalidNumber = 0;

        // when
        // then
        assertThatThrownBy(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 " + 1 + "에서 " + 9 + "까지여야 합니다.");
    }

    @DisplayName("양의 정수의 경계선인 10을 넣으면 예외가 발생한다.")
    @Test
    void validateNaturalNumberWithTen() {
        // given
        int invalidNumber = 10;

        // when
        // then
        assertThatThrownBy(() -> NumberValidator.validateNaturalNumber(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 " + 1 + "에서 " + 9 + "까지여야 합니다.");
    }

    @DisplayName("경계인 3이라면 False를 반환한다.")
    @Test
    void isBelowRequiredLength() {
        // given
        int invalidNumber = 3;

        // when
        // then
        assertThat(NumberValidator.isBelowRequiredLength(invalidNumber)).isFalse();
    }

    @DisplayName("경계인 3보다 작다면 True를 반환한다.")
    @Test
    void isBelowRequiredLengthWithTwo() {
        // given
        int invalidNumber = 2;

        // when
        // then
        assertThat(NumberValidator.isBelowRequiredLength(invalidNumber)).isTrue();
    }

    @DisplayName("중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void validateDuplicateNumberWithDuplicateNumber() {
        // given
        int duplicateNumber = 122;

        // when
        // then
        assertThatThrownBy(() -> validateDuplicateNumber(duplicateNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(duplicateNumber + ": 중복된 숫자가 존재합니다.");
    }

    @DisplayName("중복된 숫자가 없다면 예외가 발생하지 않는다.")
    @Test
    void validateDuplicateNumberWithValidNumber() {
        // given
        int validNumber = 123;

        // when
        // then
        assertThatCode(() -> validateDuplicateNumber(validNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("3자리 문자 중 숫자 외의 값을 넣으면 예외가 발생한다.")
    @Test
    void validateAllDigitsWithString() {
        // given
        String invalidInput = "12a";

        // when
        // then
        assertThatThrownBy(() -> validateAllDigits(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidInput + "은 숫자가 아닙니다.");
    }

    @DisplayName("3자리 문자 중 숫자만을 넣었으므로 예외가 발생하지 않는다.")
    @Test
    void validateAllDigitsWithOnlyDigit() {
        // given
        String validInput = "489";

        // when
        // then
        assertThatCode(() -> validateAllDigits(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 받는 문자가 3글자이기 때문에 예외가 발생하지 않는다.")
    @Test
    void validateRequiredLengthWithThree() {
        // given
        String validInput = "123";

        // when
        // then
        assertThatCode(() -> validateRequiredLength(validInput))
                .doesNotThrowAnyException();
    }

    @DisplayName("입력 받는 문자가 3글자가 아니라면 예외를 발생한다.")
    @Test
    void validateRequiredLengthWithNotThree() {
        // given
        String invalidInput = "1234";

        // when
        // then
        assertThatThrownBy(() -> validateRequiredLength(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(invalidInput + "의 길이는 " + LENGTH + "이어야 합니다.");
    }

}
