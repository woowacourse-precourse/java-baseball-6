package baseball.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InningResultTest {
    // countMatchesBetween메서드를 테스트하는 케이스
    int numberOfBalls;
    int numberOfStrikes;

    @BeforeEach
    void setup() {
        this.numberOfBalls = 0;
        this.numberOfStrikes = 0;
    }

    @Test
    void 두개의_리스트_비교() {
        InningResult oneBallOneStrikeExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(1, 3, 4)
        );
        InningResult threeStrikeExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(1, 2, 3)
        );
        InningResult nothingExpectation = InningResult.countMatchesBetween(
                List.of(1, 2, 3),
                List.of(4, 5, 6)
        );

        assertEquals("1볼 ", oneBallOneStrikeExpectation.getBallMessage());
        assertEquals("3스트라이크", threeStrikeExpectation.getStrikeMessage());
        assertEquals("낫싱", nothingExpectation.getNothingMessage());
    }
}