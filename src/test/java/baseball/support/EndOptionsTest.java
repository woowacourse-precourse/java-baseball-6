package baseball.support;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EndOptionsTest {

    @Test
    @DisplayName("1을 입력한 경우 계속")
    void isContinue() {
        // given
        Long source = 1L;

        // when
        EndOptions option = EndOptions.valueOf(source);

        // then
        assertEquals(EndOptions.CONTINUE, option);
    }

    @Test
    @DisplayName("2를 입력한 경우 종료")
    void isEnd() {
        // given
        Long source = 2L;

        // when
        EndOptions option = EndOptions.valueOf(source);

        // then
        assertEquals(EndOptions.END, option);
    }

    @Test
    @DisplayName("1, 2를 제외한 숫자를 입력한 경우 예외 발생")
    void isNotSupportOption() {
        // given
        Long source = 3L;

        // when
        try {
            EndOptions.valueOf(source);
        } catch (IllegalArgumentException e) {
            // then
            assertEquals("지원하지 않는 옵션입니다.", e.getMessage());
        }
    }
}