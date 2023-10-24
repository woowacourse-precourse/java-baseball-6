package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerResultTest {
    @Test
    void 스트라이크_확인() {
        Integer strike = 1;
        Integer ball = 2;
        PlayerResult result = new PlayerResult(strike, ball);
        Assertions.assertEquals(1, result.getStrike());
    }

    @Test
    void 볼_확인() {
        Integer strike = 1;
        Integer ball = 2;
        PlayerResult result = new PlayerResult(strike, ball);
        Assertions.assertEquals(2, result.getBall());
    }
}