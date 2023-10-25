package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

    @Test
    void randomAnswer() {
        for (int j = 0; j < 100000; j++) {
            int i = AnswerGenerator.randomAnswer();
            String s = String.valueOf(i);
            assertFalse(s.contains("0"));
            assertTrue(s.charAt(0) != s.charAt(1) && s.charAt(0) != s.charAt(2)
                    && s.charAt(1) != s.charAt(2));
            assertTrue(i >= 101 && i <= 999);
        }
    }
}