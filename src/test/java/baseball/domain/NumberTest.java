package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {


    @Test
    void 숫자가_생성된다() {
        Number number = new Number(9);
        Assertions.assertEquals(9, number.number());
    }


    @Test
    void 숫자_생성시_범위를_벗어나면_예외가_발생한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Number(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Number(10));
    }
}
