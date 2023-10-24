package baseball.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class GameResultTest {

    @Test
    void 낫싱_테스트() {
        GameResult gameResult = new GameResult(0, 0);
        Assertions.assertEquals("낫싱", gameResult.getResult());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 스트라이크_테스트(int strike) {
        GameResult gameResult = new GameResult(strike, 0);
        Assertions.assertEquals(strike+"스트라이크", gameResult.getResult());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 볼_테스트(int ball) {
        GameResult gameResult = new GameResult(0, ball);
        Assertions.assertEquals(ball+"볼 ", gameResult.getResult());
    }
}