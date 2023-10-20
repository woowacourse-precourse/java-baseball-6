package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DigitTest {

    @Nested
    @DisplayName("숫자 유효성 테스트")
    class ValidationTest {

        @ParameterizedTest
        @CsvSource({"0", "10"})
        @DisplayName("범위 외의 숫자로 각 자릿수를 만들 수 없다")
        void validationTest_whenValueIsOutOfRange_throwException(int value) {
            assertThatThrownBy(() -> Digit.from(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("각 자릿수는 1~9 이어야 합니다");
        }

        @ParameterizedTest
        @CsvSource({"1", "9"})
        @DisplayName("범위 내의 숫자로 각 자릿수를 만들 수 있다")
        void validationTest_whenValueIsInRange(int value) {
            assertDoesNotThrow(() -> Digit.from(value));
        }
    }

    @Nested
    @DisplayName("동치성 테스트")
    class EqualityTest {

        @Test
        @DisplayName("의미하는 숫자에 따라 같고 다름을 판별할 수 있다")
        void equalsTest() {
            Digit firstDigit = Digit.from(3);
            Digit secondDigit = Digit.from(3);
            Digit anotherDigit = Digit.from(4);

            assertThat(firstDigit).isEqualTo(secondDigit)
                    .isNotEqualTo(anotherDigit);
        }

        @Test
        @DisplayName("의미적으로 같은 객체는 같은 해시 코드를 가진다")
        void hashCodeTest() {
            Digit firstDigit = Digit.from(5);
            Digit secondDigit = Digit.from(5);

            assertThat(firstDigit).hasSameHashCodeAs(secondDigit);
        }
    }
}
