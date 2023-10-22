package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerTest {
    private final Computer computer = new Computer();
    @Test
    void 난수생성중복검사(){
        for(int i = 0; i < 100; i++) {
            int[] numbers = computer.initComputerNumbers();
            boolean[] duplicateCheck = new boolean[10];
            for(int j = 0; j < 3; j++){
                Assertions.assertThat(duplicateCheck[numbers[j]]).isEqualTo(false);
                duplicateCheck[numbers[j]] = true;
            }
        }
    }

    @Test
    void 판정테스트(){
        ByteArrayOutputStream testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        int[] computerNumbers = computer.initComputerNumbers();

        assertJudgeResultOutput(testOut, computerNumbers, "3스트라이크\n");
        assertJudgeResultOutput(testOut, new int[] {computerNumbers[1], computerNumbers[2], computerNumbers[0]}, "3볼\n");
        assertJudgeResultOutput(testOut, new int[] {0, computerNumbers[0], 0}, "1볼\n");
        assertJudgeResultOutput(testOut, new int[] {computerNumbers[0], computerNumbers[2], 0}, "1볼 1스트라이크\n");
        assertJudgeResultOutput(testOut, new int[] {computerNumbers[0], computerNumbers[2], computerNumbers[1]}, "2볼 1스트라이크\n");
    }
    void assertJudgeResultOutput(ByteArrayOutputStream testOut, int[] userNumbers, String outputToCompare){
        Judgement result = computer.getJudgeResult(userNumbers);
        result.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo(outputToCompare);
        testOut.reset();
    }

}
