package baseball.utils.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberSourceConverterTest {

    @Test
    @DisplayName("숫자 형식의 문자를 숫자로 변환")
    void from() {
        // given
        String source = "123";

        // when
        Long number = NumberSourceConverter.from(source);

        // then
        assertEquals(123L, number);
    }

    @Test
    @DisplayName("숫자 형식이 아닌 문자를 입력한 경우 예외 발생")
    void from_Exception() {
        // given
        String source = "abc";

        // when
        try {
            NumberSourceConverter.from(source);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("숫자만 입력 가능합니다.", e.getMessage());
        }
    }
}