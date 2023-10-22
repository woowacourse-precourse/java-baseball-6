package baseball;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ComputerTest {
    @Test
    void 난수생성중복검사(){
        Computer computer = new Computer();
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

        Computer computer = new Computer();
        int[] computerNumbers = computer.initComputerNumbers();
        Judgement result1 = computer.getJudgeResult(computerNumbers);
        Judgement result2 = computer.getJudgeResult(new int[] {computerNumbers[1], computerNumbers[2], computerNumbers[0]});
        Judgement result3 = computer.getJudgeResult(new int[] {0, computerNumbers[0], 0});
        Judgement result4 = computer.getJudgeResult(new int[] {computerNumbers[0], computerNumbers[2], 0});
        Judgement result5 = computer.getJudgeResult(new int[] {computerNumbers[0], computerNumbers[2], computerNumbers[1]});

        result1.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo("3스트라이크\n");
        testOut.reset();
        result2.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo("3볼\n");
        testOut.reset();
        result3.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo("1볼\n");
        testOut.reset();
        result4.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo("1볼 1스트라이크\n");
        testOut.reset();
        result5.printResult();
        Assertions.assertThat(testOut.toString()).isEqualTo("2볼 1스트라이크\n");
        testOut.reset();
    }

}
