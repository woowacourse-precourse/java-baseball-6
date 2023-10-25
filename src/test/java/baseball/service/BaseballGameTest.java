package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.service.BaseballGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private BaseballGame game;

    @BeforeEach
    void setUp() {
        game = new BaseballGame();
    }

    @Test
    void 볼_카운트_확인() {
        assertEquals(0, game.countBall("123", "456"));
        assertEquals(1, game.countBall("123", "345"));
        assertEquals(2, game.countBall("123", "213"));
        assertEquals(3, game.countBall("123", "312"));
    }

    @Test
    void 스트라이크_카운트_확인() {
        assertEquals(0, game.countStrike("123", "456"));
        assertEquals(1, game.countStrike("123", "156"));
        assertEquals(2, game.countStrike("123", "126"));
        assertEquals(3, game.countStrike("123", "123"));
    }
}
