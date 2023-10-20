package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberTest {

    @Nested
    @DisplayName("숫자 유효성 테스트")
    class ValidationTest {

        @ParameterizedTest
        @CsvSource({"13", "8461"})
        @DisplayName("숫자의 길이가 3이 아니면 예외를 발생시킨다")
        void validationTest_whenLengthIsNot3_throwException(int value) {
            assertThatThrownBy(() -> Number.from(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("숫자의 길이는 3이어야 합니다");
        }

        @ParameterizedTest
        @CsvSource({"433", "121", "112"})
        @DisplayName("각 숫자에 중복이 있는 경우 예외를 발생시킨다")
        void validationTest_whenDigitOverlapped_throwException(int value) {
            assertThatThrownBy(() -> Number.from(value))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("각 자릿수는 중복되어서는 안됩니다");
        }

        @ParameterizedTest
        @CsvSource({"123", "756"})
        @DisplayName("3자리 숫자이며 중복된 숫자가 없는 경우, 정상적으로 객체를 생성한다")
        void validationTest_normalCase(int value) {
            assertDoesNotThrow(() -> Number.from(value));
        }
    }

    @Nested
    @DisplayName("동치성 테스트")
    class EqualityTest {

        @Test
        @DisplayName("의미하는 숫자에 따라 같고 다름을 판별할 수 있다")
        void equalsTest() {
            Number firstNumber = Number.from(123);
            Number secondNumber = Number.from(123);
            Number anotherNumber = Number.from(124);

            assertThat(firstNumber).isEqualTo(secondNumber)
                    .isNotEqualTo(anotherNumber);
        }

        @Test
        @DisplayName("의미적으로 같은 객체는 같은 해시 코드를 가진다")
        void hashCodeTest() {
            Number firstNumber = Number.from(126);
            Number secondNumber = Number.from(126);

            assertThat(firstNumber).hasSameHashCodeAs(secondNumber);
        }
    }
}
