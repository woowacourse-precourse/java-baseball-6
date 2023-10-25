package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AnswerGeneratorTest {

    @Test
    void randomAnswer() {
        for (int j = 0; j < 100000; j++) {
            int i = AnswerGenerator.randomAnswer();
            BaseBall.getInstance(i);
        }
    }
}