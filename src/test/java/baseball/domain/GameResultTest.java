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

    @Test
    void 스트라이크_제한_개수_초과_테스트() {
        assertThrows(IllegalStateException.class,
                () -> new GameResult(10, 1)
        );
    }

    @Test
    void 볼_제한_개수_테스트() {
        assertThrows(IllegalStateException.class,
                () -> new GameResult(1, 10)
        );
    }
}