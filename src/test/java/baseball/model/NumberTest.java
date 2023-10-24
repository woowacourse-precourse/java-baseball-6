package baseball.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberTest {

    @Test
    @DisplayName("Number 객체 안에 저장되는 value 값의 범위는 1부터 9사이어야 한다.")
    public void is_Number_Value_Range_1to9() {
        assertThrows(IllegalArgumentException.class, () -> new Number(0));
        assertThrows(IllegalArgumentException.class, () -> new Number(10));
    }

}