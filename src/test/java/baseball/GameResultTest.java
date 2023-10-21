package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("GameResult 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameResultTest {
    @Test
    void toString을_호출한다() {
        GameResult result1 = new GameResult(1, 2);
        assertEquals("2볼 1스트라이크", result1.toString());

        GameResult result2 = new GameResult(0, 0);
        assertEquals("낫싱", result2.toString());

        GameResult result3 = new GameResult(2, 0);
        assertEquals("2스트라이크", result3.toString());

        GameResult result4 = new GameResult(0, 2);
        assertEquals("2볼", result4.toString());
    }

    @Test
    void 모든_숫자가_스트라이크가_맞는지_확인한다() {
        GameResult result1 = new GameResult(1, 2);
        assertFalse(result1.isAllStrike());

        GameResult result2 = new GameResult(3, 0);
        assertTrue(result2.isAllStrike());
    }
}
