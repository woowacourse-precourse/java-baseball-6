package baseball.controller;

import baseball.model.numbers.RandomAnswerGenerator;
import baseball.model.numbers.GameNumbers;
import org.junit.jupiter.api.Test;

class RandomAnswerGeneratorTest {
    RandomAnswerGenerator randomAnswerGenerator = new RandomAnswerGenerator();

    @Test
    void generateAnser() {
        // given

        for (int i = 0; i < 10; i++) {
            // when
            GameNumbers gameNumbers = randomAnswerGenerator.generateAnswer();
            System.out.printf("%2d%2d%2d\n", gameNumbers.get(0), gameNumbers.get(1), gameNumbers.get(2));
            System.out.println("-------------------");
        }
        // then
    }
}
