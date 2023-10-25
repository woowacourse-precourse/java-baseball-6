package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.number.Number;
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
}
