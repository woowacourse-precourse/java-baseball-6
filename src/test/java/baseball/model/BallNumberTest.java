package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {
    @Test
    @DisplayName("공 번호가 1부터 9사이가 아니라면, 예외처리한다.")
    void ThrowException_When_BallNumberIsNotIn1To10() {
        // given
        int testNumber = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumber(testNumber);
        });
    }
}