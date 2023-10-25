package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameLogicTest {

    private GameLogic gameLogic;

    @BeforeEach
    void setUp() {
        gameLogic = new GameLogic();
    }

    @Test
    void 볼_카운트_확인() {
        assertEquals(0, gameLogic.countBall("123", "456"));
        assertEquals(1, gameLogic.countBall("123", "345"));
        assertEquals(2, gameLogic.countBall("123", "213"));
        assertEquals(3, gameLogic.countBall("123", "312"));
    }

    @Test
    void 스트라이크_카운트_확인() {
        assertEquals(0, gameLogic.countStrike("123", "456"));
        assertEquals(1, gameLogic.countStrike("123", "156"));
        assertEquals(2, gameLogic.countStrike("123", "126"));
        assertEquals(3, gameLogic.countStrike("123", "123"));
    }
}
