package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 도메인 클래스의 객체에")
class NumberTest {

    @Nested
    @DisplayName("동일한지 비교 요청시")
    class TestEquals {

        @Test
        @DisplayName("동일한 숫자를 가졌을 경우")
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
        @DisplayName("동일한 숫자를 가졌을 경우")
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
}
