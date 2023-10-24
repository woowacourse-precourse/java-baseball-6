package baseball.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballGameValueGeneratorTest {
    private BaseballGameValueGenerator generator;

    @BeforeEach
    void init() {
        generator = new BaseballGameValueGenerator();
    }

    @Test
    void 세개의_수를_생성해야_함() {
        Assertions.assertEquals(3, generator.generateThreeRandomNumbers().size());
        Assertions.assertEquals(3, generator.generateThreeRandomNumbers().size());
        Assertions.assertEquals(3, generator.generateThreeRandomNumbers().size());
        Assertions.assertEquals(3, generator.generateThreeRandomNumbers().size());
    }
}