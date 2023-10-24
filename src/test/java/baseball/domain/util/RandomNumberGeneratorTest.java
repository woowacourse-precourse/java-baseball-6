package baseball.domain.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RandomNumberGeneratorTest {

    @Test
    void 일정_구간의_랜덤한_값이_생성되는지_테스트() {
        RandomNumberGenerator generator = new BaseballRandomNumberGenerator();

        for (int i = 0; i < 10000; i++) {
            int generatedNumber = generator.generate();
            assertTrue(generatedNumber >= 1 && generatedNumber <= 9,
                    "생성되는 값이 1~9 사이의 범위가 아닙니다.: " + generatedNumber);
        }
    }

}