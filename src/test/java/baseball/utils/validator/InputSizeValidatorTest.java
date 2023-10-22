package baseball.utils.validator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputSizeValidatorTest {

    @Test
    @DisplayName("입력 길이 비교")
    void isSame() {
        // given
        Long source = 1L;
        Long target = 1L;

        // when
        InputSizeValidator.isSame(source, target);

        // then
        assertTrue(true);
    }

    @Test
    @DisplayName("입력 길이가 달라 비교 실패 예외")
    void isSame_Fail() {
        // given
        Long source = 1L;
        Long target = 2L;

        // when
        try {
            InputSizeValidator.isSame(source, target);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("입력 길이가 맞지 않습니다.", e.getMessage());
        }
    }
}