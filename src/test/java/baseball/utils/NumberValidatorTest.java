package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @Test
    @DisplayName("1부터 9까지의 서로 다른 수로 이루어진 3자리의 수가 주어질 경우 예외를 발생시키지 않는다.")
    void doesNotThrowExceptionOfThreeDigitNumberComposedOfDifferent1To9() {
        //given
        String inputNumber = "123";

        //when //then
        assertThatCode(() -> NumberValidator.validateThreeDistinctDigitsInRange(inputNumber))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1부터 9까지의 수가 포함되어 있지 않은 경우 예외를 발생키신다.")
    void throwExceptionOfNotContainPositiveDigit() {
        //given
        String inputNumber = "120";

        //when //then
        assertThatThrownBy(() -> NumberValidator.validateThreeDistinctDigitsInRange(inputNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력은 1부터 9 까지의 숫자로만 이루어져 있어야 합니다.");
    }

    @Test
    @DisplayName("3자리보다 많은 길이의 수가 주어질 경우 예외를 발생키신다.")
    void throwExceptionOfNumberSizeOver3() {
        //given
        String inputNumber = "1234";

        //when //then
        assertThatThrownBy(() -> NumberValidator.validateThreeDistinctDigitsInRange(inputNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 수의 자리 수는 3이어야 합니다.");
    }

    @Test
    @DisplayName("3자리보다 적은 길이의 수가 주어질 경우 예외를 발생키신다.")
    void throwExceptionOfNumberSizeLess3() {
        //given
        String inputNumber = "12";

        //when //then
        assertThatThrownBy(() -> NumberValidator.validateThreeDistinctDigitsInRange(inputNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 수의 자리 수는 3이어야 합니다.");
    }

    @Test
    @DisplayName("3자리보다 적은 길이의 수가 주어질 경우 예외를 발생키신다.")
    void throwExceptionOfContainDuplicateNumber() {
        //given
        String inputNumber = "111";

        //when //then
        assertThatThrownBy(() -> NumberValidator.validateThreeDistinctDigitsInRange(inputNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("입력된 수는 서로 다른 수로 구성되어야 합니다.");
    }
}