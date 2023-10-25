package baseball.domain;

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