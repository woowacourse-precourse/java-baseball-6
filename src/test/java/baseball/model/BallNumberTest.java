package baseball.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumberTest {
    @Test
    @DisplayName("공 번호가 1부터 9사이가 아니라면, 예외처리한다.")
    void throw_exception_when_ballNumber_is_not_in_1to10() {
        // given
        int testNumber = 10;

        // when & then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BallNumber(testNumber);
        });
    }
}