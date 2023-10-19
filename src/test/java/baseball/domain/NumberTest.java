package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {

    @Test
    @DisplayName("숫자 ")
    void 숫자_생성시_범위를_벗어나면_예외가_발생한다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Number(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Number(10));
    }
}
