package baseball.utils.converter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersConverterTest {

    @Test
    @DisplayName("숫자를 숫자 리스트로 변환")
    void from() {
        // given
        Long source = 123L;

        // when
        List<Long> numbers = NumbersConverter.from(source);

        // then
        Assertions.assertAll(
            () -> assertEquals(3, numbers.size()),
            () -> assertEquals(1L, numbers.get(0)),
            () -> assertEquals(2L, numbers.get(1)),
            () -> assertEquals(3L, numbers.get(2))
        );
    }

    @Test
    @DisplayName("숫자 범위를 벗어난 숫자를 입력한 경우 예외 발생")
    void from_Range_Exception() {
        // given
        Long source = 120L;

        // when
        try {
            NumbersConverter.from(source);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("입력 범위를 벗어났습니다.", e.getMessage());
        }
    }

    @Test
    @DisplayName("중복 숫자를 입력한 경우 예외 발생")
    void from_Duplicate_Exception() {
        // given
        Long source = 112L;

        // when
        try {
            NumbersConverter.from(source);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("중복된 숫자가 있습니다.", e.getMessage());
        }
    }
}