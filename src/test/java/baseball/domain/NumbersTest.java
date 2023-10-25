package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("숫자 일급 컬렉션의 객체에")
class NumbersTest {

    @Test
    @DisplayName("인덱스에 해당하는 값 요청시 그에 맞는 값을 반환하는가")
    void getByIndex() {
        // given
        final Numbers numbers = new Numbers(List.of(1, 2, 3));

        // when
        final Number result = numbers.valueAtIndex(0);

        // then
        assertThat(result).isEqualTo(new Number(1));
    }

    @Nested
    @DisplayName("값을 갖고있는지 확인 요청시")
    class Contains {

        @Test
        @DisplayName("가지고 있는 경우 true를 반환하는가")
        void hasEqualValue() {
            // given
            final Numbers numbers = new Numbers(List.of(1, 2, 3));

            // when
            final boolean result = numbers.contains(new Number(1));

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("가지고 있는 경우 true를 반환하는가")
        void noEqualValue() {
            // given
            final Numbers numbers = new Numbers(List.of(1, 2, 3));

            // when
            final boolean result = numbers.contains(new Number(4));

            // then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("같은 위치에 같은 값이 있는지 확인 요청시")
    class HasSameIndexAndValue {

        @Test
        @DisplayName("조건에 부합하는 값이면 true를 반환하는가")
        void same() {
            // given
            final Numbers numbers = new Numbers(List.of(1, 2, 3));

            // when
            final boolean result = numbers.hasSameIndexAndValue(new Number(1), 0);

            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("존재하는 값이 다른 위치에 있는 경우 false를 반환하는가")
        void notSame() {
            // given
            final Numbers numbers = new Numbers(List.of(1, 2, 3));

            // when
            final boolean result = numbers.hasSameIndexAndValue(new Number(1), 1);

            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("존재하는 값이 다른 위치에 있는 경우 false를 반환하는가")
        void notExistingValue() {
            // given
            final Numbers numbers = new Numbers(List.of(1, 2, 3));

            // when
            final boolean result = numbers.hasSameIndexAndValue(new Number(4), 1);

            // then
            assertThat(result).isFalse();
        }
    }

    @Nested
    @DisplayName("생성시")
    class CreateValidation {

        @Test
        @DisplayName("리스트의 원소 개수가 3개가 아닌경우 예외를 던진다")
        void listSizeGreaterThantThree() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Numbers(List.of(1, 2, 3, 4)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("중복값이 존재하는 경우 예외를 던진다")
        void notUniqueElements() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new Numbers(List.of(1, 2, 1)))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
