package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void 스트라이크_볼_개수_테스트() {
        GameResult result = new GameResult(2, 1);

        assertEquals(2, result.getStrike());
        assertEquals(1, result.getBall());
    }
}