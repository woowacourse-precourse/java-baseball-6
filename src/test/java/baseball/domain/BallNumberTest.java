package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallNumberTest {

    @Test
    void 유효한_BallNumber생성() {
        BallNumber ballNumber1 = new BallNumber(1);
        BallNumber ballNumber9 = new BallNumber(9);
        assertThat(ballNumber1).isEqualTo(new BallNumber(1));
        assertThat(ballNumber9).isEqualTo(new BallNumber(9));
    }

    @Test
    void 유효하지않은_BallNumber생성() {
        assertThrows(IllegalArgumentException.class, () -> new BallNumber(0));
        assertThrows(IllegalArgumentException.class, () -> new BallNumber(10));
    }
}