package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 도메인 클래스의 객체에")
class NumberTest {

    @Nested
    @DisplayName("동일한지 비교 요청시")
    class Equals {

        @Test
        @DisplayName("동일한 숫자를 가진 경우 true를 반환하는가")
        void equalValue() {
            // given
            final Number value = new Number(1);
            final Number compare = new Number(1);

            // when
            final boolean result = value.equals(compare);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("다른 숫자를 가진 경우 false를 반환하는가")
        void differentValue() {
            // given
            final Number value = new Number(1);
            final Number compare = new Number(2);

            // when
            final boolean result = value.equals(compare);

            // then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("생성시")
    class CreateValidation {

        @Test
        @DisplayName("최소 숫자보다 작은 값인 경우 예외를 던진다")
        void lessThanMinimum() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Number(0)).isInstanceOf(IllegalStateException.class);
        }

        @Test
        @DisplayName("최대 숫자보다 큰 값인 경우 예외를 던진다")
        void greaterThanMaximum() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Number(10)).isInstanceOf(IllegalStateException.class);
        }
    }
}
