package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    void 스트라이크가_3개이면_스트라이크아웃이다() {
        GameResult gameResult = new GameResult();

        gameResult.strike();
        gameResult.strike();
        gameResult.strike();

        Assertions.assertEquals(3, gameResult.getStrikeCount());
        Assertions.assertTrue(gameResult.isStrikeOut());
    }

    @Test
    void 하나라도_볼이면_스트라이크아웃이아니다() {
        GameResult gameResult = new GameResult();

        gameResult.ball();
        gameResult.strike();
        gameResult.strike();

        Assertions.assertTrue(gameResult.hasBall());
        Assertions.assertTrue(gameResult.hasStrike());

        Assertions.assertFalse(gameResult.isStrikeOut());
    }

    @Test
    void 스트라이크_볼_갯수가_둘다_0일경우_낫싱이다() {
        GameResult gameResult = new GameResult();

        Assertions.assertFalse(gameResult.hasBall());
        Assertions.assertFalse(gameResult.hasStrike());
        Assertions.assertFalse(gameResult.isStrikeOut());
    }
}
