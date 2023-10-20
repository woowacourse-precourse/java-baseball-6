package baseball.computer.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.computer.RandomComputerNumberGenerator;
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

}
