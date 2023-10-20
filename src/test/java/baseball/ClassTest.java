package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("클래스별 기능 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class ClassTest {
    @Test
    void GameResult_클래스의_getter가_잘_호출되어야_한다() {
        GameResult result = new GameResult(1, 2);

        assertEquals(1, result.getStrike());
        assertEquals(2, result.getBall());
    }
}
