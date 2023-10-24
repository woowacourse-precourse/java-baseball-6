package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    @DisplayName("Number가 반환된다.")
    public void createNumber() {
        // given
        Number number = new Number(1);

        // when
        int result = number.number();

        // then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("음수일 경우 IllegalArgumentException을 반환한다.")
    public void 음수일_경우_IllegalArgumentException을_반환한다() {
        // given
        Number number = new Number(-1);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> number.checkValidate());
    }

    @Test
    @DisplayName("숫자가 4 이상일 경우 IllegalArgumentException을 반환한다.")
    public void 숫자가_4_이상일_경우_IllegalArgumentException을_반환한다() {
        // given
        Number number = new Number(4);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> number.checkValidate());
    }
}
