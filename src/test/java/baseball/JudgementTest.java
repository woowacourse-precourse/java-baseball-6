package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JudgementTest {
    ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    Numbers computerNumbers;

    @BeforeEach
    void setting() {
        System.setOut(new PrintStream(testOut));
        computerNumbers = makeNumbers(new int[]{1, 2, 3});
    }

    @Test
    void 판정테스트_3스트라이크() {
        assertJudgeResultOutput(makeNumbers(new int[]{1, 2, 3}), computerNumbers, "3스트라이크\n");
    }

    @Test
    void 판정테스트_3볼() {
        assertJudgeResultOutput(makeNumbers(new int[]{2, 3, 1}), computerNumbers, "3볼\n");
    }

    @Test
    void 판정테스트_1볼() {
        assertJudgeResultOutput(makeNumbers(new int[]{3, 5, 6}), computerNumbers, "1볼\n");
    }

    @Test
    void 판정테스트_1볼1스트라이크() {
        assertJudgeResultOutput(makeNumbers(new int[]{1, 3, 6}), computerNumbers, "1볼 1스트라이크\n");
    }

    @Test
    void 판정테스트_2볼1스트라이크() {
        assertJudgeResultOutput(makeNumbers(new int[]{3, 2, 1}), computerNumbers, "2볼 1스트라이크\n");
    }

    Numbers makeNumbers(int[] list) {
        Numbers numbers = new Numbers();
        for (int number : list) {
            numbers.addNumber(new Number(number));
        }
        return numbers;
    }

    void assertJudgeResultOutput(Numbers userNumbers, Numbers computerNumbers, String outputToCompare) {
        Judgement result = new Judgement(userNumbers, computerNumbers);
        result.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo(outputToCompare);
        testOut.reset();
    }
}
